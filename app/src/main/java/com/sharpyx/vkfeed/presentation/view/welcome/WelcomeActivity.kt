package com.sharpyx.vkfeed.presentation.view.welcome

import android.content.Intent
import android.os.Bundle
import com.arellomobile.mvp.MvpAppCompatActivity
import com.arellomobile.mvp.presenter.InjectPresenter
import com.arellomobile.mvp.presenter.ProvidePresenter
import com.sharpyx.vkfeed.App
import com.sharpyx.vkfeed.R
import com.sharpyx.vkfeed.di.component.DaggerActivityComponent
import com.sharpyx.vkfeed.extension.toast
import com.sharpyx.vkfeed.presentation.presenter.WelcomePresenter
import com.sharpyx.vkfeed.presentation.view.news.NewsActivity
import com.vk.sdk.VKAccessToken
import com.vk.sdk.VKCallback
import com.vk.sdk.VKScope
import com.vk.sdk.VKSdk
import com.vk.sdk.api.VKError
import kotlinx.android.synthetic.main.activity_welcome.*

/**
 * Welcome activity for authorization feature
 * @author Artem Sckopincev (aka sharpyx)
 */
class WelcomeActivity : MvpAppCompatActivity(), IWelcomeView {

    @InjectPresenter
    lateinit var welcomePresenter: WelcomePresenter

    @ProvidePresenter
    fun providePresenter(): WelcomePresenter {
        val interactor = DaggerActivityComponent.builder()
                .appComponent((applicationContext as App).getComponent())
                .build()
                .getUserInteractor()
        return WelcomePresenter(interactor)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_welcome)

        // start auth dialog
        btnLogIn.setOnClickListener { welcomePresenter.startAuth() }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        onVkActivityResult(requestCode, resultCode, data)

        super.onActivityResult(requestCode, resultCode, data)
    }

    // Handle VK activity result after authorization
    private fun onVkActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        val callback = object : VKCallback<VKAccessToken> {
            override fun onResult(res: VKAccessToken?) {
                welcomePresenter.onAuthResult(res)
            }

            override fun onError(error: VKError?) {
                welcomePresenter.onAuthError(error)
            }
        }

        VKSdk.onActivityResult(requestCode, resultCode, data, callback)
    }

    override fun showAuthDialog() {
        VKSdk.login(this, VKScope.WALL, VKScope.FRIENDS)
    }

    override fun startNewsActivity() {
        val intent = Intent(this, NewsActivity::class.java)
        startActivity(intent)
        finish()
    }

    override fun showAuthError(error: String?) {
        var msg = getString(R.string.msg_error)

        if (error != null) {
            msg += "\n $error"
        }

        toast(msg)
    }
}

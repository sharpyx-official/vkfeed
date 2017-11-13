package com.sharpyx.vkfeed.presentation.view.launch

import android.content.Intent
import android.os.Bundle
import com.arellomobile.mvp.MvpAppCompatActivity
import com.arellomobile.mvp.presenter.InjectPresenter
import com.arellomobile.mvp.presenter.ProvidePresenter
import com.sharpyx.vkfeed.App
import com.sharpyx.vkfeed.di.component.DaggerActivityComponent
import com.sharpyx.vkfeed.presentation.presenter.LaunchPresenter
import com.sharpyx.vkfeed.presentation.view.news.NewsActivity
import com.sharpyx.vkfeed.presentation.view.welcome.WelcomeActivity

/**
 * Splash-screen. Will display on few milliseconds. Implemented by style with background image.
 * @author Artem Sckopincev (aka sharpyx)
 */
class LaunchActivity : MvpAppCompatActivity(), ILaunchView {

    @InjectPresenter
    lateinit var launchPresenter: LaunchPresenter

    @ProvidePresenter
    fun providePresenter(): LaunchPresenter {
        val interactor = DaggerActivityComponent.builder()
                .appComponent((applicationContext as App).getComponent())
                .build()
                .getUserInteractor()
        return LaunchPresenter(interactor)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        launchPresenter.navigateNext()
    }

    override fun navigateToAuth() {
        val intent = Intent(this, WelcomeActivity::class.java)
        startActivity(intent)
        finish()
    }

    override fun navigateToNews() {
        val intent = Intent(this, NewsActivity::class.java)
        startActivity(intent)
        finish()
    }
}

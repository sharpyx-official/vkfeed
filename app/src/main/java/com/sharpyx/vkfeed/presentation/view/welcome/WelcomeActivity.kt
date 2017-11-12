package com.sharpyx.vkfeed.presentation.view.welcome

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.sharpyx.vkfeed.R
import com.sharpyx.vkfeed.extension.toast
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
class WelcomeActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_welcome)

        btnLogIn.setOnClickListener {
            VKSdk.login(this, VKScope.FRIENDS, VKScope.WALL)
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        onVkActivityResult(requestCode, resultCode, data)

        super.onActivityResult(requestCode, resultCode, data)
    }

    // Handle VK activity result after authorization
    private fun onVkActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        val callback = object : VKCallback<VKAccessToken> {
            override fun onResult(res: VKAccessToken?) {
                toast("Auth is successfully finished!")
                Log.d("VKAuth", "res: " + res?.accessToken)
            }

            override fun onError(error: VKError?) {
                toast("Auth failed. Error description in logs.")
                Log.d("VKAuth", "Error on auth: \n" + error.toString())
            }
        }

        VKSdk.onActivityResult(requestCode, resultCode, data, callback)
    }
}

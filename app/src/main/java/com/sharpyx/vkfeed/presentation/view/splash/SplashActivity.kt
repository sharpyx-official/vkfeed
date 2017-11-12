package com.sharpyx.vkfeed.presentation.view.splash

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.sharpyx.vkfeed.presentation.view.welcome.WelcomeActivity

/**
 * Splash-screen. Will display on few milliseconds. Implemented by style with background image.
 * @author Artem Sckopincev (aka sharpyx)
 */
class SplashActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val intent = Intent(this, WelcomeActivity::class.java)
        startActivity(intent)
        finish()
    }
}

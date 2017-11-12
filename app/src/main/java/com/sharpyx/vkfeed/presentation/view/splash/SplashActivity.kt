package com.sharpyx.vkfeed.presentation.view.splash

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.sharpyx.vkfeed.presentation.view.news.NewsActivity
import com.sharpyx.vkfeed.presentation.view.welcome.WelcomeActivity
import com.sharpyx.vkfeed.repositories.UserRepository
import javax.inject.Inject

/**
 * Splash-screen. Will display on few milliseconds. Implemented by style with background image.
 * @author Artem Sckopincev (aka sharpyx)
 */
class SplashActivity : AppCompatActivity() {

    @Inject
    lateinit var userRepository: UserRepository

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val intent: Intent = if (userRepository.isAuthorized) {
            Intent(this, WelcomeActivity::class.java)
        } else {
            Intent(this, NewsActivity::class.java)
        }

        startActivity(intent)
        finish()
    }
}

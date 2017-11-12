package com.sharpyx.vkfeed

import android.app.Application
import com.sharpyx.vkfeed.di.component.AppComponent
import com.vk.sdk.VKSdk

/**
 * @author Artem Sckopincev (aka sharpyx)
 */
class App : Application() {

    // private lateinit var appComponent: AppComponent

    override fun onCreate() {
        super.onCreate()

        // Initialize VK SDK
        VKSdk.initialize(this)

        // Setup Dagger 2

    }
}
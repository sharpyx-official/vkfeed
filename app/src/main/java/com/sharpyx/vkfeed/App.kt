package com.sharpyx.vkfeed

import android.app.Application
import com.vk.sdk.VKSdk

/**
 * @author Artem Sckopincev (aka sharpyx)
 */
class App : Application() {

    override fun onCreate() {
        super.onCreate()

        // Initialize VK SDK
        VKSdk.initialize(this)
    }
}
package com.sharpyx.vkfeed

import android.app.Application
import com.sharpyx.vkfeed.di.component.AppComponent
import com.sharpyx.vkfeed.di.component.DaggerAppComponent
import com.sharpyx.vkfeed.di.module.AppModule
import com.vk.sdk.VKSdk

/**
 * @author Artem Sckopincev (aka sharpyx)
 */
class App : Application() {

    private lateinit var appComponent: AppComponent

    override fun onCreate() {
        super.onCreate()

        // Initialize VK SDK
        VKSdk.initialize(this)

        // Initialize Dagger 2
        appComponent = DaggerAppComponent
                .builder()
                .appModule(AppModule(this))
                .build()
        appComponent.inject(this)
    }

    fun getComponent(): AppComponent {
        return appComponent
    }
}
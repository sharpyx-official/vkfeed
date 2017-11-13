package com.sharpyx.vkfeed.di.component

import android.app.Application
import android.content.Context
import com.sharpyx.vkfeed.App
import com.sharpyx.vkfeed.data.prefs.SharedPrefsHelper
import com.sharpyx.vkfeed.di.ApplicationContext
import com.sharpyx.vkfeed.di.module.AppModule
import com.sharpyx.vkfeed.di.module.ModelModule
import com.sharpyx.vkfeed.di.module.ServerModule
import dagger.Component
import javax.inject.Singleton

/**
 * @author Artem Sckopincev (aka sharpyx)
 */

@Singleton
@Component(modules = arrayOf(AppModule::class))
interface AppComponent {

    fun inject(app: App)

    @ApplicationContext
    fun getContext(): Context

    fun getApplication(): Application

    fun getSharedPrefsHelper(): SharedPrefsHelper
}
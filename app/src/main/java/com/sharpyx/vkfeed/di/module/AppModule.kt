package com.sharpyx.vkfeed.di.module

import android.app.Application
import android.content.Context
import android.content.SharedPreferences
import com.sharpyx.vkfeed.di.ApplicationContext
import dagger.Module
import dagger.Provides

/**
 * @author Artem Sckopincev (aka sharpyx)
 */
@Module
class AppModule constructor(private val application: Application) {

    @Provides
    @ApplicationContext
    fun provideContext(): Context = application

    @Provides
    fun provideApplication(): Application = application

    @Provides
    fun provideSharedPrefs(): SharedPreferences {
        return application.getSharedPreferences("main-prefs", Context.MODE_PRIVATE)
    }
}
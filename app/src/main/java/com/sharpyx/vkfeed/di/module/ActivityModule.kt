package com.sharpyx.vkfeed.di.module

import android.app.Activity
import android.content.Context
import com.sharpyx.vkfeed.di.ActivityContext
import dagger.Module
import dagger.Provides

/**
 * @author Artem Sckopincev (aka sharpyx)
 */
@Module
class ActivityModule constructor(private val activity: Activity) {

    @Provides
    @ActivityContext
    fun provideActivityContext(): Context  = activity

    @Provides
    fun provideActivity(): Activity = activity
}
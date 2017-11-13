package com.sharpyx.vkfeed.di.component

import android.app.Activity
import com.sharpyx.vkfeed.di.PerActivity
import com.sharpyx.vkfeed.di.module.ModelModule
import com.sharpyx.vkfeed.di.module.ServerModule
import com.sharpyx.vkfeed.domain.news.NewsInteractor
import com.sharpyx.vkfeed.domain.user.UserInteractor
import dagger.Component

/**
 * @author Artem Sckopincev (aka sharpyx)
 */
@PerActivity
@Component(
        dependencies = arrayOf(AppComponent::class),
        modules = arrayOf(ServerModule::class, ModelModule::class))
interface ActivityComponent {

    fun inject(activity: Activity)

    fun getUserInteractor(): UserInteractor
    fun getNewsInteractor(): NewsInteractor
}
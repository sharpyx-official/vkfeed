package com.sharpyx.vkfeed.di.component

import android.app.Activity
import com.sharpyx.vkfeed.di.PerActivity
import com.sharpyx.vkfeed.domain.user.UserInteractor
import dagger.Component

/**
 * @author Artem Sckopincev (aka sharpyx)
 */
@PerActivity
@Component(dependencies = arrayOf(AppComponent::class))
interface ActivityComponent {

    fun inject(activity: Activity)

    fun getUserInteractor(): UserInteractor
}
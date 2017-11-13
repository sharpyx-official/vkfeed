package com.sharpyx.vkfeed.di.component

import com.sharpyx.vkfeed.data.network.VkApi
import com.sharpyx.vkfeed.di.module.AppModule
import com.sharpyx.vkfeed.di.module.ServerModule
import dagger.Component
import javax.inject.Singleton

/**
 * @author Artem Sckopincev (aka sharpyx)
 */

@Singleton
@Component(modules = arrayOf(AppModule::class, ServerModule::class))
interface ModelComponent {
    fun getApi(): VkApi
}
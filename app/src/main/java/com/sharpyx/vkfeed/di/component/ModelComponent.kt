package com.sharpyx.vkfeed.di.component

import com.sharpyx.vkfeed.di.module.AppModule
import com.sharpyx.vkfeed.di.module.ModelModule
import com.sharpyx.vkfeed.di.module.ServerModule
import dagger.Component
import javax.inject.Singleton

/**
 * @author Artem Sckopincev (aka sharpyx)
 */

@Singleton
@Component(modules = arrayOf(AppModule::class, ServerModule::class, ModelModule::class))
interface ModelComponent
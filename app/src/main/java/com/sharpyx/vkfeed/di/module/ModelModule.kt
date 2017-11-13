package com.sharpyx.vkfeed.di.module

import com.sharpyx.vkfeed.domain.news.NewsInteractor
import com.sharpyx.vkfeed.system.AppSchedulers
import com.sharpyx.vkfeed.system.ISchedulersProvider
import com.sharpyx.vkfeed.domain.user.UserInteractor
import com.sharpyx.vkfeed.repositories.NewsRepository
import com.sharpyx.vkfeed.repositories.UserRepository
import dagger.Module
import dagger.Provides

/**
 * @author Artem Sckopincev (aka sharpyx)
 */
@Module
class ModelModule {

    @Provides
    fun provideAppScheduler(): ISchedulersProvider {
        return AppSchedulers()
    }

    @Provides
    fun provideUserInteractor(repository: UserRepository): UserInteractor {
        return UserInteractor(repository)
    }

    @Provides
    fun provideNewsInteractor(repository: NewsRepository): NewsInteractor {
        return NewsInteractor(repository)
    }
}
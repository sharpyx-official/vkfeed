package com.sharpyx.vkfeed.di.module

import com.sharpyx.vkfeed.domain.user.UserInteractor
import com.sharpyx.vkfeed.repositories.UserRepository
import dagger.Module
import dagger.Provides

/**
 * @author Artem Sckopincev (aka sharpyx)
 */
@Module
class ModelModule {

    @Provides
    fun provideUserInteractor(repository: UserRepository): UserInteractor {
        return UserInteractor(repository)
    }
}
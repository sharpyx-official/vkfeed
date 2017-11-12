package com.sharpyx.vkfeed.domain.user

import com.sharpyx.vkfeed.repositories.UserRepository
import javax.inject.Inject

/**
 * @author Artem Sckopincev (aka sharpyx)
 */
class UserInteractor @Inject constructor(private val userRepository: UserRepository) {

    fun isAuthorized() = userRepository.isAuthorized

    fun logIn(token: String) {
        userRepository.saveAccessToken(token)
    }

    fun logOut() {
        userRepository.clearAccessToken()
    }

}
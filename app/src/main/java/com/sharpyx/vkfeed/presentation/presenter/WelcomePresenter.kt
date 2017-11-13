package com.sharpyx.vkfeed.presentation.presenter

import com.arellomobile.mvp.InjectViewState
import com.arellomobile.mvp.MvpPresenter
import com.sharpyx.vkfeed.domain.user.UserInteractor
import com.sharpyx.vkfeed.presentation.view.welcome.IWelcomeView
import com.vk.sdk.VKAccessToken
import com.vk.sdk.api.VKError
import javax.inject.Inject

/**
 * @author Artem Sckopincev (aka sharpyx)
 */
@InjectViewState
class WelcomePresenter @Inject constructor(
        private val userInteractor: UserInteractor
) : MvpPresenter<IWelcomeView>() {

    fun startAuth() {
        viewState.showAuthDialog()
    }

    fun onAuthResult(token: VKAccessToken?) {
        if (token == null) {
            viewState.showAuthError(null)
            return
        }

        userInteractor.logIn(token.accessToken)

        viewState.startNewsActivity()
    }

    fun onAuthError(error: VKError?) {
        viewState.showAuthError(error!!.errorMessage)
    }

}
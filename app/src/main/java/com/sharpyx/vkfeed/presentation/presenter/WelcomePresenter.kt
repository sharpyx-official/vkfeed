package com.sharpyx.vkfeed.presentation.presenter

import com.arellomobile.mvp.InjectViewState
import com.arellomobile.mvp.MvpPresenter
import com.sharpyx.vkfeed.presentation.view.welcome.IWelcomeView
import com.vk.sdk.VKAccessToken
import com.vk.sdk.api.VKError

/**
 * @author Artem Sckopincev (aka sharpyx)
 */
@InjectViewState
class WelcomePresenter : MvpPresenter<IWelcomeView>() {

    fun startAuth() {
        viewState.showAuthDialog()
    }

    fun onAuthResult(token: VKAccessToken?) {
        if (token == null) {
            viewState.authError(null)
            return
        }

        viewState.authFinished()
    }

    fun onAuthError(error: VKError?) {
        viewState.authError(error!!.errorMessage)
    }

}
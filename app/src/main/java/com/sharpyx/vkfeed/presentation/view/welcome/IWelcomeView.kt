package com.sharpyx.vkfeed.presentation.view.welcome

import com.arellomobile.mvp.MvpView
import com.vk.sdk.api.VKError

/**
 * @author Artem Sckopincev (aka sharpyx)
 */
interface IWelcomeView : MvpView {

    // Shows auth dialog
    fun showAuthDialog()

    // Auth successfully finished
    fun startNewsActivity()

    // Auth error
    fun showAuthError(error: String?)

}
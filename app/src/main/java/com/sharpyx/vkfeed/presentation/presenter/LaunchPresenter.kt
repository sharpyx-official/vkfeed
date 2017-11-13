package com.sharpyx.vkfeed.presentation.presenter

import com.arellomobile.mvp.InjectViewState
import com.arellomobile.mvp.MvpPresenter
import com.sharpyx.vkfeed.domain.user.UserInteractor
import com.sharpyx.vkfeed.presentation.view.launch.ILaunchView
import javax.inject.Inject

/**
 * @author Artem Sckopincev (aka sharpyx)
 */

@InjectViewState
class LaunchPresenter @Inject constructor(
        private val userInteractor: UserInteractor
) : MvpPresenter<ILaunchView>() {

    fun navigateNext() {
        if (userInteractor.isAuthorized()) {
            viewState.navigateToNews()
        } else {
            viewState.navigateToAuth()
        }
    }
}
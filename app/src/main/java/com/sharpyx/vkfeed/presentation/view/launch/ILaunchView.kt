package com.sharpyx.vkfeed.presentation.view.launch

import com.arellomobile.mvp.MvpView

/**
 * @author Artem Sckopincev (aka sharpyx)
 */
interface ILaunchView : MvpView {

    fun navigateToAuth()

    fun navigateToNews()
}
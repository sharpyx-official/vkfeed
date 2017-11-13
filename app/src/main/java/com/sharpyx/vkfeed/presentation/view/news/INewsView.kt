package com.sharpyx.vkfeed.presentation.view.news

import com.arellomobile.mvp.MvpView

/**
 * @author Artem Sckopincev (aka sharpyx)
 */
interface INewsView : MvpView {
    fun showMsg(msg: String)
}
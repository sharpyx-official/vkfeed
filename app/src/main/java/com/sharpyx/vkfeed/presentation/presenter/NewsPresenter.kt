package com.sharpyx.vkfeed.presentation.presenter

import com.arellomobile.mvp.InjectViewState
import com.arellomobile.mvp.MvpPresenter
import com.sharpyx.vkfeed.domain.news.NewsInteractor
import com.sharpyx.vkfeed.presentation.view.news.INewsView
import javax.inject.Inject

/**
 * @author Artem Sckopincev (aka sharpyx)
 */
@InjectViewState
class NewsPresenter @Inject constructor(
        private val newsInteractor: NewsInteractor
) : MvpPresenter<INewsView>() {

    fun getNews() {
        // TODO: get news from interactor
    }
}
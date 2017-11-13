package com.sharpyx.vkfeed.presentation.view.news

import android.os.Bundle
import com.arellomobile.mvp.MvpAppCompatActivity
import com.arellomobile.mvp.presenter.InjectPresenter
import com.arellomobile.mvp.presenter.ProvidePresenter
import com.sharpyx.vkfeed.App
import com.sharpyx.vkfeed.R
import com.sharpyx.vkfeed.di.component.DaggerActivityComponent
import com.sharpyx.vkfeed.di.module.ModelModule
import com.sharpyx.vkfeed.di.module.ServerModule
import com.sharpyx.vkfeed.extension.toast
import com.sharpyx.vkfeed.presentation.presenter.NewsPresenter

class NewsActivity : MvpAppCompatActivity(), INewsView {

    @InjectPresenter
    lateinit var newsPresenter: NewsPresenter

    @ProvidePresenter
    fun providePresenter(): NewsPresenter {
        val interactor = DaggerActivityComponent.builder()
                .appComponent((applicationContext as App).getComponent())
                .modelModule(ModelModule())
                .serverModule(ServerModule())
                .build()
                .getNewsInteractor()
        return NewsPresenter(interactor)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_news)

        newsPresenter.getNews()
    }

    override fun showMsg(msg: String) {
        toast(msg)
    }
}

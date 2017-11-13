package com.sharpyx.vkfeed.repositories

import com.sharpyx.vkfeed.data.network.VkApi
import com.sharpyx.vkfeed.entity.NewsFeed
import com.sharpyx.vkfeed.system.ISchedulersProvider
import io.reactivex.Single
import javax.inject.Inject

/**
 * @author Artem Sckopincev (aka sharpyx)
 */
class NewsRepository @Inject constructor(
        private val api: VkApi,
        private val schedulers: ISchedulersProvider
) {

    private val count: Int = 10

    fun getNewsNext(): Single<NewsFeed> = api.getNews(count)
            .subscribeOn(schedulers.io())
            .observeOn(schedulers.ui())
}
package com.sharpyx.vkfeed.data.network

import com.sharpyx.vkfeed.entity.NewsFeed
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Query

/**
 * @author Artem Sckopincev (aka sharpyx)
 */
interface VkApi {

    @GET("newsfeed.get")
    fun getNews(
            @Query("count") count: Int,
            @Query("filters") filters: String = "post"
    ): Single<NewsFeed>
}
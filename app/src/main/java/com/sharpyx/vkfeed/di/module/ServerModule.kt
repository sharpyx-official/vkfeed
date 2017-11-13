package com.sharpyx.vkfeed.di.module

import com.google.gson.Gson
import com.google.gson.GsonBuilder
import com.sharpyx.vkfeed.data.network.VkApi
import com.sharpyx.vkfeed.data.network.interceptor.TokenQueryInterceptor
import com.sharpyx.vkfeed.data.prefs.SharedPrefsHelper
import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

/**
 * @author Artem Sckopincev (aka sharpyx)
 */
@Module
class ServerModule {

    private val baseUri = "https://api.vk.com/method/"

    @Provides
    fun provideGson(): Gson {
        return GsonBuilder().create()
    }

    @Provides
    fun provideOkHttpClient(prefs: SharedPrefsHelper): OkHttpClient {
        val token = prefs.getString(SharedPrefsHelper.KEY_ACCESS_TOKEN)
        val builder = OkHttpClient.Builder()
        builder.addNetworkInterceptor(TokenQueryInterceptor(token))
        builder.readTimeout(30, TimeUnit.SECONDS)
        return builder.build()
    }

    @Provides
    fun provideApi(client: OkHttpClient, gson: Gson): VkApi {
        return Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create(gson))
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .client(client)
                .baseUrl(baseUri)
                .build()
                .create(VkApi::class.java)
    }
}
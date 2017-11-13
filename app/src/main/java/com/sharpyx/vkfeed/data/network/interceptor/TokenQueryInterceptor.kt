package com.sharpyx.vkfeed.data.network.interceptor

import okhttp3.Interceptor
import okhttp3.Response

/**
 * Added token on each request to VK API
 * @author Artem Sckopincev (aka sharpyx)
 */
class TokenQueryInterceptor(private val token: String) : Interceptor {

    companion object {
        val QUERY_TOKEN = "access_token"
    }

    override fun intercept(chain: Interceptor.Chain): Response {
        var request = chain.request()
        if (!token.isEmpty()) {
            val url = request.url().newBuilder().addQueryParameter(QUERY_TOKEN, token).build()
            request = request.newBuilder().url(url).build()
        }
        return chain.proceed(request)
    }

}
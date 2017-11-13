package com.sharpyx.vkfeed.domain.news

import com.sharpyx.vkfeed.repositories.NewsRepository
import javax.inject.Inject

/**
 * @author Artem Sckopincev (aka sharpyx)
 */

class NewsInteractor @Inject constructor(private val newsRepository: NewsRepository) {

    fun getNewsNext() = newsRepository.getNewsNext()
}
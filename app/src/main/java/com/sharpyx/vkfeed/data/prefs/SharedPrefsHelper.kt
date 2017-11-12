package com.sharpyx.vkfeed.data.prefs

import android.content.SharedPreferences
import javax.inject.Inject

/**
 * @author Artem Sckopincev (aka sharpyx)
 */
class SharedPrefsHelper @Inject constructor(private val prefs: SharedPreferences) {

    companion object {
        val DEFAULT_STRING = ""
        val KEY_ACCESS_TOKEN = "access-token"
    }

    fun getString(key: String) = prefs.getString(key, DEFAULT_STRING)

    fun getBoolean(key: String) = prefs.getBoolean(key, false)
}
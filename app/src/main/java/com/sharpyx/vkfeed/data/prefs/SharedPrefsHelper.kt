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
        val KEY_USER_ID = "user-id"
    }

    fun getString(key: String) = prefs.getString(key, DEFAULT_STRING)

    fun getBoolean(key: String) = prefs.getBoolean(key, false)

    fun getLong(key: String) = prefs.getLong(key, 0)

    fun saveString(key: String, value: String) {
        prefs.edit().putString(key, value).apply()
    }

    fun saveBoolean(key: String, value: Boolean) {
        prefs.edit().putBoolean(key, value).apply()
    }

    fun saveLong(key: String, value: Long) {
        prefs.edit().putLong(key, value).apply()
    }

    fun removeKey(key: String) = prefs.edit().remove(key).apply()
}
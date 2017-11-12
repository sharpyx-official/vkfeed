package com.sharpyx.vkfeed.repositories

import com.sharpyx.vkfeed.data.prefs.SharedPrefsHelper
import javax.inject.Inject

/**
 * @author Artem Sckopincev (aka sharpyx)
 */
class UserRepository @Inject constructor(private val prefs: SharedPrefsHelper) {

    val isAuthorized get() = !prefs.getString(SharedPrefsHelper.KEY_ACCESS_TOKEN).isNullOrEmpty()

    fun getAccessToken(): String = prefs.getString(SharedPrefsHelper.KEY_ACCESS_TOKEN)

    fun saveAccessToken(token: String) {
        prefs.saveString(SharedPrefsHelper.KEY_ACCESS_TOKEN, token)
    }

    fun clearAccessToken() {
        prefs.removeKey(SharedPrefsHelper.KEY_ACCESS_TOKEN)
    }
}
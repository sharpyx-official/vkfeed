package com.sharpyx.vkfeed.entity

import com.google.gson.annotations.SerializedName

/**
 * @author Artem Sckopincev (aka sharpyx)
 */
data class Profile (
        @SerializedName("id") val id: Long,
        @SerializedName("first_name") val firstName: String,
        @SerializedName("last_name") val lastName: String,
        @SerializedName("online") val online: Boolean,
        @SerializedName("photo_200", alternate = arrayOf("photo_100", "photo_50")) val photoUri: String
)
package com.sharpyx.vkfeed.entity

import com.google.gson.annotations.SerializedName

/**
 * @author Artem Sckopincev (aka sharpyx)
 */

data class Group (
        @SerializedName("id") val id: Long,
        @SerializedName("name") val name: String,
        @SerializedName("photo_200", alternate = arrayOf("photo_100", "photo_50")) val photoUri: String
)
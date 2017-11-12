package com.sharpyx.vkfeed.entity

import com.google.gson.annotations.SerializedName

/**
 * @author Artem Sckopincev (aka sharpyx)
 */
data class LikesInfo (
        @SerializedName("count") val count: Int,
        @SerializedName("user_likes") val hasUserLiked: Boolean,
        @SerializedName("can_like") val canLike: Boolean
)
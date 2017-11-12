package com.sharpyx.vkfeed.entity

import com.google.gson.annotations.SerializedName

/**
 * @author Artem Sckopincev (aka sharpyx)
 */
open class CommentsInfo (
        @SerializedName("count") val count: Int,
        @SerializedName("can_post") val canPost: Boolean
)
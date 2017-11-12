package com.sharpyx.vkfeed.entity

import com.google.gson.annotations.SerializedName

/**
 * @author Artem Sckopincev (aka sharpyx)
 */
data class RepostsInfo (
        @SerializedName("count") val count: Int,
        @SerializedName("user_reposted") val hasUserReposted: Boolean
)
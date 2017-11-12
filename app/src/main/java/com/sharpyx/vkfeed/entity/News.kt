package com.sharpyx.vkfeed.entity

import com.google.gson.annotations.SerializedName
import java.util.Date

/**
 * @author Artem Sckopincev (aka sharpyx)
 */
data class News (
        @SerializedName("source_id") val sourceId: Long,
        @SerializedName("post_id") val postId: Long,
        @SerializedName("date") val date: Date,
        @SerializedName("text") val text: String,
        @SerializedName("comments") val commentsInfo: CommentsInfo,
        @SerializedName("likes") val likesInfo: LikesInfo,
        @SerializedName("reposts") val repostsInfo: RepostsInfo
)
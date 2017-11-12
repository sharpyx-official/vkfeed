package com.sharpyx.vkfeed.entity

import com.google.gson.annotations.SerializedName

/**
 * Contains information for one part of a news feed
 * @author Artem Sckopincev (aka sharpyx)
 */
data class NewsFeed (
        // News items
        @SerializedName("items") val items: List<News>,
        // Groups info
        @SerializedName("groups") val groups: List<Group>,
        // Profiles info
        @SerializedName("profiles") val profiles: List<Profile>,
        // Data for request the next page
        @SerializedName("new_offset") val newOffset: String,
        // Data which allows exclude duplicates
        @SerializedName("start_offset") val startOffset: String
)
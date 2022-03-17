package com.gapo.gapoproject.domain.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName


data class NewsFeedResponse(
    @Expose
    @SerializedName("items")
    val items: List<NewFeed>?,
)

data class NewFeed(
    @Expose
    @SerializedName("document_id")
    val id: String?,
    @Expose
    @SerializedName("title")
    val title: String?,
    @Expose
    @SerializedName("description")
    val description: String?,
    @Expose
    @SerializedName("images")
    val images: List<Images?>?,
)

data class Images(
    @Expose
    @SerializedName("href")
    val href: String?,
)
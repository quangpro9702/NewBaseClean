package com.gapo.gapoproject.domain.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName


data class NewFeedDetailResponse(
    @Expose
    @SerializedName("document_id")
    val id: String?,
    @Expose
    @SerializedName("title")
    val title: String?,
    @Expose
    @SerializedName("published_date")
    val published_date: String?,
    @Expose
    @SerializedName("origin_url")
    val origin_url: String?,
    @Expose
    @SerializedName("description")
    val description: String?,
    @Expose
    @SerializedName("publisher")
    val publisher: Publisher?,
)

data class Publisher(
    @Expose
    @SerializedName("icon")
    val icon: String?,
)
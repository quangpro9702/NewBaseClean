package com.gapo.gapoproject.presentation.model

import com.gapo.gapoproject.domain.model.NewFeedDetailResponse
import com.gapo.gapoproject.domain.model.Publisher
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class NewFeedDetailUIModel(
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
    val publisher: PublisherUIModel?,
)


fun NewFeedDetailResponse.mapToUIModel() = NewFeedDetailUIModel(
    id, title, published_date, origin_url, description, publisher?.mapToUIModel()
)

data class PublisherUIModel(
    @Expose
    @SerializedName("icon")
    val icon: String?,
)


fun Publisher.mapToUIModel() = PublisherUIModel(
    icon
)
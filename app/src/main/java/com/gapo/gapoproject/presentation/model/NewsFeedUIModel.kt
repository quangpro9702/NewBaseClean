package com.gapo.gapoproject.presentation.model

import com.gapo.gapoproject.domain.model.Images
import com.gapo.gapoproject.domain.model.NewFeed
import com.gapo.gapoproject.domain.model.NewsFeedResponse
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class NewsFeedUIModel(
    @Expose
    @SerializedName("items")
    val items: List<NewFeedUIModel>?,
)

fun NewsFeedResponse.mapToUIModel() = NewsFeedUIModel(
    this.items?.map {
        it.mapToUIModel()
    }
)


data class NewFeedUIModel(
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
    val images: List<ImagesUIModel?>?,
)

fun NewFeed.mapToUIModel() = NewFeedUIModel(
    id, title, description, images?.map { it?.mapToUIModel() }
)


data class ImagesUIModel(
    @Expose
    @SerializedName("href")
    val href: String?,
)

fun Images.mapToUIModel() = ImagesUIModel(
    href
)

package com.gapo.gapoproject.data.local

import com.gapo.gapoproject.domain.model.NewFeedDetailResponse
import com.gapo.gapoproject.domain.model.NewsFeedResponse
import kotlinx.coroutines.flow.Flow

interface NewsFeedDataSource {
    fun getNewsFeed(): Flow<NewsFeedResponse?>

    fun getNewFeedDetail(): Flow<NewFeedDetailResponse?>
}
package com.gapo.gapoproject.domain.repository

import com.gapo.gapoproject.domain.model.NewFeedDetailResponse
import com.gapo.gapoproject.domain.model.NewsFeedResponse
import kotlinx.coroutines.flow.Flow

interface NewsFeedRepository {
    suspend fun getNewsFeed(): Flow<NewsFeedResponse?>

    suspend fun getNewFeedDetail(): Flow<NewFeedDetailResponse?>
}
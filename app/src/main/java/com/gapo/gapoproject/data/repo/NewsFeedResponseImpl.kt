package com.gapo.gapoproject.data.repo

import com.gapo.gapoproject.data.local.NewsFeedDataSource
import com.gapo.gapoproject.domain.model.NewFeedDetailResponse
import com.gapo.gapoproject.domain.model.NewsFeedResponse
import com.gapo.gapoproject.domain.repository.NewsFeedRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class NewsFeedResponseImpl @Inject constructor(private val dataSource: NewsFeedDataSource) :
    NewsFeedRepository {
    override suspend fun getNewsFeed(): Flow<NewsFeedResponse?> {
        return dataSource.getNewsFeed()
    }

    override suspend fun getNewFeedDetail(): Flow<NewFeedDetailResponse?> {
        return dataSource.getNewFeedDetail()
    }
}

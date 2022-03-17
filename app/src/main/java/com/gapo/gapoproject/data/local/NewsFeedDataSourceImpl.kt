package com.gapo.gapoproject.data.local

import android.content.Context
import com.gapo.gapoproject.data.base.BaseSource
import com.gapo.gapoproject.domain.model.NewFeedDetailResponse
import com.gapo.gapoproject.domain.model.NewsFeedResponse
import kotlinx.coroutines.channels.awaitClose
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.callbackFlow
import javax.inject.Inject

class NewsFeedDataSourceImpl @Inject constructor(
    private val context: Context
) : NewsFeedDataSource,
    BaseSource<NewsFeedResponse>() {
    override fun getNewsFeed(): Flow<NewsFeedResponse?> = callbackFlow {
        this.trySend(
            getData(context, "newsfeed.json")
        ).isSuccess
        awaitClose { close() }
    }

    override fun getNewFeedDetail(): Flow<NewFeedDetailResponse?> = callbackFlow {
        this.trySend(
            getData(context, "detail.json")
        ).isSuccess
        awaitClose { close() }
    }
}
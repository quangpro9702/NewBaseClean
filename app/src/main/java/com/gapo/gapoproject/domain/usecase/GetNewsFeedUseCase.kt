package com.gapo.gapoproject.domain.usecase

import com.gapo.gapoproject.domain.base.BaseUseCase
import com.gapo.gapoproject.domain.model.NewsFeedResponse
import com.gapo.gapoproject.domain.repository.NewsFeedRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetNewsFeedUseCase @Inject constructor(
    private val newsFeedRepository: NewsFeedRepository
) : BaseUseCase<BaseUseCase.Params, Flow<NewsFeedResponse?>>() {
    override suspend fun execute(params: Params?): Flow<NewsFeedResponse?> {
        return newsFeedRepository.getNewsFeed()
    }
}
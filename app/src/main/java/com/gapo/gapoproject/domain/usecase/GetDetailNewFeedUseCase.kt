package com.gapo.gapoproject.domain.usecase

import com.gapo.gapoproject.domain.base.BaseUseCase
import com.gapo.gapoproject.domain.model.NewFeedDetailResponse
import com.gapo.gapoproject.domain.repository.NewsFeedRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetDetailNewFeedUseCase @Inject constructor(private val repository: NewsFeedRepository) :
    BaseUseCase<BaseUseCase.Params, Flow<NewFeedDetailResponse?>>() {
    override suspend fun execute(params: Params?): Flow<NewFeedDetailResponse?> {
        return repository.getNewFeedDetail()
    }
}
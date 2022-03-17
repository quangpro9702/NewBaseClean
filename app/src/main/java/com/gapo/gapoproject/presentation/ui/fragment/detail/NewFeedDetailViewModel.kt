package com.gapo.gapoproject.presentation.ui.fragment.detail

import androidx.lifecycle.LiveData
import com.gapo.gapoproject.domain.base.BaseUseCase
import com.gapo.gapoproject.domain.model.NewFeedDetailResponse
import com.gapo.gapoproject.domain.model.NewsFeedResponse
import com.gapo.gapoproject.domain.usecase.GetDetailNewFeedUseCase
import com.gapo.gapoproject.domain.usecase.GetNewsFeedUseCase
import com.gapo.gapoproject.presentation.common.BaseViewModel
import com.gapo.gapoproject.presentation.model.NewFeedDetailUIModel
import com.gapo.gapoproject.presentation.model.mapToUIModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class NewFeedDetailViewModel @Inject constructor(
    private val getNewFeedDetailUseCase: GetDetailNewFeedUseCase
) : BaseViewModel() {

    private val _getNewFeedDetail: LiveData<NewFeedDetailUIModel?> = androidx.lifecycle.liveData {
        getNewFeedDetailUseCase.execute().collect {
            emit(it?.mapToUIModel())
        }
    }

    val getNewFeedDetail  =_getNewFeedDetail
}


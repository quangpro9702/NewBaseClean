package com.gapo.gapoproject.presentation.ui.fragment.list

import androidx.lifecycle.LiveData
import com.gapo.gapoproject.domain.model.NewsFeedResponse
import com.gapo.gapoproject.domain.usecase.GetNewsFeedUseCase
import com.gapo.gapoproject.presentation.common.BaseViewModel
import com.gapo.gapoproject.presentation.model.NewsFeedUIModel
import com.gapo.gapoproject.presentation.model.mapToUIModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class NewsFeedViewModel @Inject constructor(
    private val getNewsFeedUseCase: GetNewsFeedUseCase
) : BaseViewModel() {

    private val _getNewsFeed: LiveData<NewsFeedUIModel?> = androidx.lifecycle.liveData {
        getNewsFeedUseCase.execute().collect {
            emit(it?.mapToUIModel())
        }
    }

    val getNewsFeed  =_getNewsFeed
}


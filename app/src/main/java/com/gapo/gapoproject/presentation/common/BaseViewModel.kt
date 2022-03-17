package com.gapo.gapoproject.presentation.common

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.switchMap
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.Dispatchers
import kotlin.coroutines.CoroutineContext
import kotlin.experimental.ExperimentalTypeInference

abstract class BaseViewModel : ViewModel() {

    private val handler = CoroutineExceptionHandler { _: CoroutineContext, throwable: Throwable ->
        Log.e(TAG, "${throwable.message}")
    }

    @OptIn(ExperimentalTypeInference::class)
    fun <Y> liveData(
        dispatcher: CoroutineDispatcher = Dispatchers.IO,
        @BuilderInference block: suspend () -> Y
    ): LiveData<Y> = androidx.lifecycle.liveData(handler + dispatcher) {
        emit(block())
    }

    @OptIn(ExperimentalTypeInference::class)
    open fun <Y> liveDataEmit(
        dispatcher: CoroutineDispatcher = Dispatchers.IO,
        @BuilderInference block: suspend () -> Y
    ): LiveData<Y> = androidx.lifecycle.liveData(handler + dispatcher) {
        emit(block())
    }


    open fun <X, Y> LiveData<X>.switchMapLiveDataEmit(
        dispatcher: CoroutineDispatcher = Dispatchers.IO,
        block: suspend (X) -> Y
    ): LiveData<Y> = switchMap {
        androidx.lifecycle.liveData(handler + dispatcher) {
            emit(block(it))
        }
    }

    companion object {
        const val TAG = "CoroutineException"
    }
}
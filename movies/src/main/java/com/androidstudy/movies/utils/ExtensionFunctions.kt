package com.androidstudy.movies.utils

import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.LiveData
import com.androidstudy.movies.data.datastates.NetworkResult
import java.io.IOException

fun <T> LiveData<T>.nonNull(): NonNullMediatorLiveData<T> {
    val mediator: NonNullMediatorLiveData<T> =
        NonNullMediatorLiveData()
    mediator.addSource(this) { it?.let { mediator.value = it } }
    return mediator
}

fun <T> NonNullMediatorLiveData<T>.observe(owner: LifecycleOwner, observer: (t: T) -> Unit) {
    this.observe(owner, androidx.lifecycle.Observer {
        it?.let(observer)
    })
}

suspend fun <T : Any> safeApiCall(
    call: suspend () -> NetworkResult<T>,
    errorMessage: String
): NetworkResult<T> = try {
    call.invoke()
} catch (e: Exception) {
    NetworkResult.Error(IOException(errorMessage, e))
}




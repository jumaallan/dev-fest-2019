package com.androidstudy.weather.ui.views.utils

import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.LiveData
import com.androidstudy.weather.ui.views.datastates.NetworkResult
import java.io.IOException
import java.text.SimpleDateFormat
import java.util.*

fun <T> LiveData<T>.nonNull(): NonNullMediatorLiveData<T> {
    val mediator: NonNullMediatorLiveData<T> = NonNullMediatorLiveData()
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

val <T> T.exhaustive: T get() = this

fun Long.toDate(pattern: String): String {
    val date = Date(this * 1000)
    val formatter = SimpleDateFormat(pattern)
    return formatter.format(date)
}

fun Int.toDate(pattern: String): String {
    val date = Date((this * 1000).toLong())
    val formatter = SimpleDateFormat(pattern)
    return formatter.format(date)
}
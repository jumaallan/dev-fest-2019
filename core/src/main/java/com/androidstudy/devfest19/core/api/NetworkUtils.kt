package com.androidstudy.devfest19.core.api

import java.io.IOException

suspend fun <T : Any> safeApiCall(
    call: suspend () -> NetworkResult<T>,
    errorMessage: String
): NetworkResult<T> = try {
    call.invoke()
} catch (e: Exception) {
    NetworkResult.Error(IOException(errorMessage, e))
}
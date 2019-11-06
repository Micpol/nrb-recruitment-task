package com.micpol.norbsoft_recruitment_task.data.network.response

import com.micpol.norbsoft_recruitment_task.data.source.Resource

sealed class ApiResponse<out T> {

    class Success<out T>(val data: T) : ApiResponse<T>()

    class Error(val error: Throwable) : ApiResponse<Nothing>()
}

fun <T> ApiResponse<T>.toResource(): Resource<T> {
    return when (this) {
        is ApiResponse.Success -> Resource.Success(data)
        is ApiResponse.Error -> Resource.Error(error)
    }
}

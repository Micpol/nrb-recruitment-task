package com.micpol.norbsoft_recruitment_task.data.source

import com.micpol.norbsoft_recruitment_task.data.model.Channel
import com.micpol.norbsoft_recruitment_task.data.network.ApiService
import com.micpol.norbsoft_recruitment_task.data.network.RequestExecutor
import com.micpol.norbsoft_recruitment_task.data.network.response.ApiResponse
import com.micpol.norbsoft_recruitment_task.data.network.response.toResource
import javax.inject.Inject

class NetworkDataSource @Inject constructor(

    private val requestExecutor: RequestExecutor,
    private val apiService: ApiService

) : DataSource {

    override suspend fun loadChannels(): Resource<List<Channel>> {
        return when (val value = requestExecutor.execute(apiService.loadChannels())) {
            is ApiResponse.Success -> {
                val list = value.data.items
                value.data.items?.let {
                    ApiResponse.Success(it)
                } ?: ApiResponse.Success(listOf<Channel>())
            }
            is ApiResponse.Error -> value
        }.toResource()
    }
}

package com.micpol.norbsoft_recruitment_task.data.network

import com.micpol.norbsoft_recruitment_task.data.model.NorbsoftResponse
import retrofit2.Response
import retrofit2.http.GET

interface ApiService {
    @GET("/sciTube/v2/channels.json")
    suspend fun loadChannels(): Response<NorbsoftResponse>
}

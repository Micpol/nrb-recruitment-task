package com.micpol.norbsoft_recruitment_task.data.source

import com.micpol.norbsoft_recruitment_task.data.model.Channel

interface DataSource {
    suspend fun loadChannels(): Resource<List<Channel>>
}

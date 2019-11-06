package com.micpol.norbsoft_recruitment_task.feature.home

import com.micpol.norbsoft_recruitment_task.data.source.DataSource
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class ChannelsRepository @Inject constructor(

    private val networkDataSource: DataSource

) {

    suspend fun loadChannels() = withContext(Dispatchers.IO) {
        networkDataSource.loadChannels()
    }
}

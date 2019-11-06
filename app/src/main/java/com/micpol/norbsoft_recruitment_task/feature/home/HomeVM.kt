package com.micpol.norbsoft_recruitment_task.feature.home

import androidx.lifecycle.*
import com.micpol.norbsoft_recruitment_task.data.model.Channel
import com.micpol.norbsoft_recruitment_task.data.source.Resource
import kotlinx.coroutines.launch
import javax.inject.Inject

abstract class HomeVM : ViewModel() {
    abstract val channels: LiveData<List<Channel>>

    abstract fun loadChannels()
}

class HomeVMImpl @Inject constructor(

    private val repository: ChannelsRepository

) : HomeVM() {

    private val channelsData by lazy { MutableLiveData<Resource<List<Channel>>>() }


    override fun loadChannels() {
        channelsData.postValue(Resource.Loading)
        viewModelScope.launch {
            channelsData.postValue(repository.loadChannels())
        }
    }

    override val channels by lazy {
        channelsData.map {
            if (it is Resource.Success) {
                it.data
            } else {
                emptyList()
            }
        }
    }

}
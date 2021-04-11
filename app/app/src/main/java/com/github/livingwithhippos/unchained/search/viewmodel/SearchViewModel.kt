package com.github.livingwithhippos.unchained.search.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.github.livingwithhippos.unchained.data.orion.model.AppDetails
import com.github.livingwithhippos.unchained.data.orion.model.SearchResult
import com.github.livingwithhippos.unchained.data.orion.repository.AppDetailsRepository
import com.github.livingwithhippos.unchained.data.orion.repository.StreamSearchRepository
import com.github.livingwithhippos.unchained.utilities.Event
import com.github.livingwithhippos.unchained.utilities.postEvent
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SearchViewModel @Inject constructor(
    private val appDetailsRepository: AppDetailsRepository,
    private val streamSearchRepository: StreamSearchRepository,
) : ViewModel() {
    // todo: use new paging tutorial and https://github.com/michaelbull/kotlin-result instead of arrow's either
    val appDetailsLiveData = MutableLiveData<Event<AppDetails?>>()
    val resultLiveData = MutableLiveData<Event<SearchResult?>>()

    fun fetchAppDetails() {
        viewModelScope.launch {
            // todo: get user key and pass it
            val response = appDetailsRepository.getDetails()
            appDetailsLiveData.postEvent(response)
        }
    }

    fun fetchQueryResults(type: String, query: String) {
        viewModelScope.launch {
            val response = streamSearchRepository.searchStreamQuery(type = type, query = query)
            resultLiveData.postEvent(response)
        }
    }
}
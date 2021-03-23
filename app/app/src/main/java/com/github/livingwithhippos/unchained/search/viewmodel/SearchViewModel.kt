package com.github.livingwithhippos.unchained.search.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.github.livingwithhippos.unchained.data.oriondroid.model.AppDetails
import com.github.livingwithhippos.unchained.data.oriondroid.repository.AppDetailsRepository
import com.github.livingwithhippos.unchained.data.repositoy.CredentialsRepository
import com.github.livingwithhippos.unchained.utilities.Event
import com.github.livingwithhippos.unchained.utilities.postEvent
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SearchViewModel @Inject constructor(
    private val appDetailsRepository: AppDetailsRepository
) : ViewModel() {
    // todo: use new paging tutorial and https://github.com/michaelbull/kotlin-result instead of arrow's either
    val resultLiveData = MutableLiveData<Event<AppDetails?>>()

    fun fetchAppDetails() {
        viewModelScope.launch {
            // todo: get user key and pass it
            val response = appDetailsRepository.getDetails()
            resultLiveData.postEvent(response)
        }
    }
}
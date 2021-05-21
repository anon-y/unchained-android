package com.github.livingwithhippos.unchained.search.viewmodel

import android.content.SharedPreferences
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.github.livingwithhippos.unchained.data.orion.model.SearchResult
import com.github.livingwithhippos.unchained.data.orion.repository.StreamSearchRepository
import com.github.livingwithhippos.unchained.search.viewmodel.ODWelcomeViewModel.Companion.KEY_ORION_API
import com.github.livingwithhippos.unchained.utilities.Event
import com.github.livingwithhippos.unchained.utilities.postEvent
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SearchViewModel @Inject constructor(
    private val preferences: SharedPreferences,
    private val streamSearchRepository: StreamSearchRepository,
) : ViewModel() {
    val resultLiveData = MutableLiveData<Event<SearchResult?>>()

    fun search(query: String, type: String, limit: Int = 5) {
        viewModelScope.launch {
            val apiKey = getApiKey()
            if (apiKey.length > 10) {
                val response = streamSearchRepository.searchStreamQuery(
                    userKey = apiKey,
                    type = type,
                    query = query,
                    limitCount = limit)
                resultLiveData.postEvent(response)
            } else {
                // pass error message
            }
        }
    }

    private fun getApiKey(): String {
        return preferences.getString(KEY_ORION_API, "") ?: ""
    }
}
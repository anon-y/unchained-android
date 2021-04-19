package com.github.livingwithhippos.unchained.search.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.github.livingwithhippos.unchained.data.orion.model.ODUser
import com.github.livingwithhippos.unchained.data.orion.repository.ODVariousRepository
import com.github.livingwithhippos.unchained.utilities.Event
import com.github.livingwithhippos.unchained.utilities.postEvent
import kotlinx.coroutines.launch
import javax.inject.Inject

class ODWelcomeViewModel @Inject constructor(
    private val variousRepository: ODVariousRepository
) : ViewModel() {

    val userLiveData: MutableLiveData<Event<ODUser?>> = MutableLiveData()

    fun checkCredentials(userApiKey: String){
        viewModelScope.launch {
            val response = variousRepository.getUser(userApiKey)
            userLiveData.postEvent(response)
        }
    }
}
package com.github.livingwithhippos.unchained.search.viewmodel

import android.content.SharedPreferences
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.github.livingwithhippos.unchained.data.orion.model.ODUser
import com.github.livingwithhippos.unchained.data.orion.repository.ODVariousRepository
import com.github.livingwithhippos.unchained.data.service.ForegroundTorrentService
import com.github.livingwithhippos.unchained.utilities.Event
import com.github.livingwithhippos.unchained.utilities.postEvent
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ODWelcomeViewModel @Inject constructor(
    private val preferences: SharedPreferences,
    private val variousRepository: ODVariousRepository,
) : ViewModel() {

    val userLiveData: MutableLiveData<Event<ODUser?>> = MutableLiveData()

    fun checkAndSaveCredentials(userApiKey: String){
        viewModelScope.launch {
            val user = variousRepository.getUser(userApiKey)
            if (user != null)
                saveCredentials(userApiKey)

            userLiveData.postEvent(user)
        }
    }

    fun checkCurrentCredentials(): Boolean {
        val key = preferences.getString(KEY_ORION_API, "") ?: ""
        return key.length > 10
    }

    private fun saveCredentials(userApiKey: String) {
        with(preferences.edit()) {
            putString(KEY_ORION_API, userApiKey)
            apply()
        }
    }

    companion object {
        const val KEY_ORION_API = "orion_api_key"
    }
}
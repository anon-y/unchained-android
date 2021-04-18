package com.github.livingwithhippos.unchained.data.orion.repository

import com.github.livingwithhippos.unchained.data.orion.model.ODUser
import com.github.livingwithhippos.unchained.data.orion.remote.ODVariousApiHelper
import com.github.livingwithhippos.unchained.data.repositoy.BaseRepository
import com.github.livingwithhippos.unchained.utilities.ORION_USER_KEY
import javax.inject.Inject

class ODVariousRepository @Inject constructor(private val apiHelper: ODVariousApiHelper) :
    BaseRepository() {

    suspend fun getUser(
        userApikey: String = ORION_USER_KEY
    ): ODUser? {

        return safeApiCall(
            call = { apiHelper.getUser(userApikey) },
            errorMessage = "Error Fetching User Info"
        )
    }
}
package com.github.livingwithhippos.unchained.data.orion.repository

import com.github.livingwithhippos.unchained.data.orion.model.AppDetails
import com.github.livingwithhippos.unchained.data.orion.remote.AppDetailsHelper
import com.github.livingwithhippos.unchained.data.repositoy.BaseRepository
import com.github.livingwithhippos.unchained.utilities.ORION_USER_KEY
import javax.inject.Inject

class AppDetailsRepository @Inject constructor(private val appDetailsHelper: AppDetailsHelper) :
    BaseRepository() {

        suspend fun getDetails(
            userApikey: String = ORION_USER_KEY
        ): AppDetails? {
            val detailsResponse = safeApiCall(
                call = { appDetailsHelper.getDetails(userApikey) },
                errorMessage = "Error Fetching Streaming Info"
            )

            return detailsResponse
        }
}
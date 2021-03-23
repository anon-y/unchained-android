package com.github.livingwithhippos.unchained.data.oriondroid.repository

import com.github.livingwithhippos.unchained.data.oriondroid.model.AppDetails
import com.github.livingwithhippos.unchained.data.oriondroid.remote.AppDetailsHelper
import com.github.livingwithhippos.unchained.data.repositoy.BaseRepository
import com.github.livingwithhippos.unchained.utilities.ORIONDROID_USER_KEY
import javax.inject.Inject

class AppDetailsRepository @Inject constructor(private val appDetailsHelper: AppDetailsHelper) :
    BaseRepository() {

        suspend fun getDetails(
            userApikey: String = ORIONDROID_USER_KEY
        ): AppDetails? {
            val detailsResponse = safeApiCall(
                call = { appDetailsHelper.getDetails(userApikey) },
                errorMessage = "Error Fetching Streaming Info"
            )

            return detailsResponse
        }
}
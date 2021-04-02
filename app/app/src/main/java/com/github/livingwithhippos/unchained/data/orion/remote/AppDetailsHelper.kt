package com.github.livingwithhippos.unchained.data.orion.remote

import com.github.livingwithhippos.unchained.data.orion.model.AppDetails
import retrofit2.Response

interface AppDetailsHelper {

    suspend fun getDetails(userKey: String): Response<AppDetails>
}
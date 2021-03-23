package com.github.livingwithhippos.unchained.data.oriondroid.remote

import com.github.livingwithhippos.unchained.data.oriondroid.model.AppDetails
import retrofit2.Response

interface AppDetailsHelper {

    suspend fun getDetails(userKey: String): Response<AppDetails>
}
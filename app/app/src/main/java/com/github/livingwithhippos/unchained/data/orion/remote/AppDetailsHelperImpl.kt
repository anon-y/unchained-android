package com.github.livingwithhippos.unchained.data.orion.remote

import com.github.livingwithhippos.unchained.data.orion.model.AppDetails
import retrofit2.Response
import javax.inject.Inject

class AppDetailsHelperImpl  @Inject constructor(private val appDetailsApi: AppDetailsApi) : AppDetailsHelper {
    override suspend fun getDetails(userKey: String): Response<AppDetails> = appDetailsApi.getDetails(userKey = userKey)
}
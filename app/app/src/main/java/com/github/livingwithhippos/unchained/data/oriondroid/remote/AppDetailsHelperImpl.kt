package com.github.livingwithhippos.unchained.data.oriondroid.remote

import com.github.livingwithhippos.unchained.data.oriondroid.model.AppDetails
import retrofit2.Response
import javax.inject.Inject

class AppDetailsHelperImpl  @Inject constructor(private val appDetailsApi: AppDetailsApi) : AppDetailsHelper {
    override suspend fun getDetails(userApiKey: String): Response<AppDetails> = appDetailsApi.getDetails(userKey = userApiKey)
}
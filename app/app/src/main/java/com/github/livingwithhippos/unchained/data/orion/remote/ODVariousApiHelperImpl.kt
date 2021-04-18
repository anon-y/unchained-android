package com.github.livingwithhippos.unchained.data.orion.remote

import com.github.livingwithhippos.unchained.data.orion.model.ODUser
import retrofit2.Response
import javax.inject.Inject

class ODVariousApiHelperImpl @Inject constructor(private val odVariousApi: ODVariousApi) : ODVariousApiHelper {
    override suspend fun getUser(userApiKey: String): Response<ODUser> = odVariousApi.getUser(userKey = userApiKey)
}
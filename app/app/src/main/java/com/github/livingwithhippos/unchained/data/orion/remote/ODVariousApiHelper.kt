package com.github.livingwithhippos.unchained.data.orion.remote

import com.github.livingwithhippos.unchained.data.orion.model.ODUser
import retrofit2.Response

interface ODVariousApiHelper {
    suspend fun getUser(userKey: String): Response<ODUser>
}
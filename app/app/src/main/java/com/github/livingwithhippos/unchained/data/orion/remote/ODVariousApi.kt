package com.github.livingwithhippos.unchained.data.orion.remote

import com.github.livingwithhippos.unchained.data.orion.model.ODUser
import com.github.livingwithhippos.unchained.utilities.ORION_UNCHAINED_APP_KEY
import retrofit2.Response
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.POST

interface ODVariousApi {

    @FormUrlEncoded
    @POST("/")
    suspend fun getUser(
        @Field("mode") mode: String = "user",
        @Field("action") action: String = "retrieve",
        @Field("keyuser") userKey: String,
        @Field("keyapp") appKey: String = ORION_UNCHAINED_APP_KEY
    ): Response<ODUser>

}
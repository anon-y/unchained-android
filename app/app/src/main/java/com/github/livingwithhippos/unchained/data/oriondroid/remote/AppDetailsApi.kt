package com.github.livingwithhippos.unchained.data.oriondroid.remote

import com.github.livingwithhippos.unchained.data.oriondroid.model.AppDetails
import com.github.livingwithhippos.unchained.utilities.ORIONDROID_UNCHAINED_APP_KEY
import com.github.livingwithhippos.unchained.utilities.ORIONDROID_USER_KEY
import retrofit2.Response
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.POST

interface AppDetailsApi {

    @FormUrlEncoded
    @POST("/")
    suspend fun getDetails(
        @Field("mode") mode: String = "app",
        @Field("action") action: String = "retrieve",
        @Field("keyuser") userKey: String,
        @Field("keyapp") appKey: String = ORIONDROID_UNCHAINED_APP_KEY
    ): Response<AppDetails>

}
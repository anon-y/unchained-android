package com.github.livingwithhippos.unchained.data.orion.remote

import com.github.livingwithhippos.unchained.data.orion.model.SearchResult
import retrofit2.Response

interface StreamSearchHelper {

    suspend fun searchStreamQuery(
        userKey: String,
        type: String,
        query: String,
        limitCount: Int,
        seeds: Int,
        videoQuality: String,
        audioLanguages: String
    ): Response<SearchResult>
}
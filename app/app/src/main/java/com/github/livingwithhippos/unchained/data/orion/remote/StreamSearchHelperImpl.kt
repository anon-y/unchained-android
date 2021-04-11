package com.github.livingwithhippos.unchained.data.orion.remote

import com.github.livingwithhippos.unchained.data.orion.model.SearchResult
import retrofit2.Response
import javax.inject.Inject

class StreamSearchHelperImpl @Inject constructor(private val streamSearchApi: StreamSearchApi) :
    StreamSearchHelper {
    override suspend fun searchStreamQuery(
        userKey: String,
        type: String,
        query: String,
        limitCount: Int,
        seeds: Int,
        videoQuality: String,
        audioLanguages: String
    ): Response<SearchResult> = streamSearchApi.searchStreamQuery(
        userKey = userKey,
        type = type,
        query = query,
        limitCount = limitCount,
        seeds = seeds,
        videoQuality = videoQuality,
        audioLanguages = audioLanguages
    )
}
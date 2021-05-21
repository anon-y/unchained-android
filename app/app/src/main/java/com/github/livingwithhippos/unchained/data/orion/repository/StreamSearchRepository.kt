package com.github.livingwithhippos.unchained.data.orion.repository

import com.github.livingwithhippos.unchained.data.orion.model.SearchResult
import com.github.livingwithhippos.unchained.data.orion.remote.DEFAULT_STREAM_LANGUAGE
import com.github.livingwithhippos.unchained.data.orion.remote.DEFAULT_STREAM_QUALITY
import com.github.livingwithhippos.unchained.data.orion.remote.StreamSearchHelper
import com.github.livingwithhippos.unchained.data.repositoy.BaseRepository
import com.github.livingwithhippos.unchained.utilities.ORION_USER_KEY
import javax.inject.Inject

class StreamSearchRepository @Inject constructor(private val streamSearchHelper: StreamSearchHelper) :
    BaseRepository() {

    /**
     * Search a movie/show on Orion.
     * @param userKey the user api key, personal
     * @param type 'movie' or 'show'
     * @param query the string to search
     * @param limitCount the number of results to return, default 10
     * @param seeds the minimum seeds for torrents/magnets, default 10
     * @param videoQuality the accepted video quality separated by commas, like "hd720,hd1080"
     * @param audioLanguages the stream language in two letters country codes. Default "en" for english
     *
     * @return a [SearchResult] item with all the results
     */
    suspend fun searchStreamQuery(
        userKey: String = ORION_USER_KEY,
        type: String,
        query: String,
        limitCount: Int = 10,
        seeds: Int = 10,
        videoQuality: String = DEFAULT_STREAM_QUALITY,
        audioLanguages: String = DEFAULT_STREAM_LANGUAGE
    ): SearchResult? {
        // todo: use [Either]?
        val searchResponse = safeApiCall(
        call = {
            streamSearchHelper.searchStreamQuery(
                userKey,
                type,
                query,
                limitCount,
                seeds,
                videoQuality,
                audioLanguages
            )
        },
        errorMessage = "Error Fetching Stream Search Results"
        )

        return searchResponse
    }
}
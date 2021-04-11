package com.github.livingwithhippos.unchained.data.orion.remote

import com.github.livingwithhippos.unchained.data.orion.model.SearchResult
import com.github.livingwithhippos.unchained.utilities.ORION_UNCHAINED_APP_KEY
import retrofit2.Response
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.POST

const val MOVIES = "movie"
const val SHOWS = "show"
const val DEFAULT_STREAM_TYPE="torrent,hoster"
const val DEFAULT_STREAM_ACCESS="direct,indirect"
const val DEFAULT_STREAM_QUALITY="hd720,hd1080,hd2k,hd4k,hd6k,hd8k"
const val DEFAULT_STREAM_LANGUAGE="en"

interface StreamSearchApi {

    @FormUrlEncoded
    @POST("/")
    suspend fun searchStreamQuery(
        @Field("mode") mode: String = "stream",
        @Field("action") action: String = "retrieve",
        @Field("keyuser") userKey: String,
        @Field("keyapp") appKey: String = ORION_UNCHAINED_APP_KEY,
        @Field("type") type: String,
        @Field("query") query: String,
        @Field("limitcount") limitCount: Int = 10,
        @Field("streamseeds") seeds: Int = 10,
        @Field("streamtype") streamType: String = DEFAULT_STREAM_TYPE,
        @Field("access") access: String = DEFAULT_STREAM_ACCESS,
        @Field("videoquality") videoQuality: String = DEFAULT_STREAM_QUALITY,
        @Field("audiolanguages") audioLanguages: String = DEFAULT_STREAM_LANGUAGE,
    ): Response<SearchResult>

    @FormUrlEncoded
    @POST("/")
    suspend fun searchStreamImdb(
        @Field("mode") mode: String = "stream",
        @Field("action") action: String = "retrieve",
        @Field("keyuser") userKey: String,
        @Field("keyapp") appKey: String = ORION_UNCHAINED_APP_KEY,
        @Field("type") type: String = MOVIES,
        @Field("idimdb") imdbID: String
    ): Response<SearchResult>

    @FormUrlEncoded
    @POST("/")
    suspend fun searchStreamTmdb(
        @Field("mode") mode: String = "stream",
        @Field("action") action: String = "retrieve",
        @Field("keyuser") userKey: String,
        @Field("keyapp") appKey: String = ORION_UNCHAINED_APP_KEY,
        @Field("type") type: String = MOVIES,
        @Field("idtmdb") tmdbID: String
    ): Response<SearchResult>

    @FormUrlEncoded
    @POST("/")
    suspend fun searchStreamTvdb(
        @Field("mode") mode: String = "stream",
        @Field("action") action: String = "retrieve",
        @Field("keyuser") userKey: String,
        @Field("keyapp") appKey: String = ORION_UNCHAINED_APP_KEY,
        @Field("type") type: String = SHOWS,
        @Field("idtvdb") tvdbID: String
    ): Response<SearchResult>

    @FormUrlEncoded
    @POST("/")
    suspend fun searchStreamTvrage(
        @Field("mode") mode: String = "stream",
        @Field("action") action: String = "retrieve",
        @Field("keyuser") userKey: String,
        @Field("keyapp") appKey: String = ORION_UNCHAINED_APP_KEY,
        @Field("type") type: String = SHOWS,
        @Field("idtvrage") tvrageID: String
    ): Response<SearchResult>

    @FormUrlEncoded
    @POST("/")
    suspend fun searchStreamTracktv(
        @Field("mode") mode: String = "stream",
        @Field("action") action: String = "retrieve",
        @Field("keyuser") userKey: String,
        @Field("keyapp") appKey: String = ORION_UNCHAINED_APP_KEY,
        @Field("type") type: String = MOVIES,
        @Field("idtrakt") traktID: String
    ): Response<SearchResult>

}
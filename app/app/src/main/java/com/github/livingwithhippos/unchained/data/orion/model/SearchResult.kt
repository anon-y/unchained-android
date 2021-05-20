package com.github.livingwithhippos.unchained.data.orion.model

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class SearchResult(
    @Json(name = "data")
    val searchData: SearchData,
    @Json(name = "name")
    val name: String,
    @Json(name = "result")
    val result: StreamResult,
    @Json(name = "version")
    val version: String
)

@JsonClass(generateAdapter = true)
data class SearchData(
    @Json(name = "count")
    val count: Count,
    @Json(name = "movie")
    val movie: Movie,
    @Json(name = "requests")
    val requests: OrionRequests,
    @Json(name = "streams")
    val streams: List<OrionStream>,
    @Json(name = "type")
    val type: String
)

@JsonClass(generateAdapter = true)
data class StreamResult(
    @Json(name = "description")
    val description: String,
    @Json(name = "message")
    val message: String,
    @Json(name = "status")
    val status: String,
    @Json(name = "type")
    val type: String
)

@JsonClass(generateAdapter = true)
data class Count(
    @Json(name = "requested")
    val requested: Int,
    @Json(name = "retrieved")
    val retrieved: Int,
    @Json(name = "total")
    val total: Int
)

@JsonClass(generateAdapter = true)
data class Movie(
    @Json(name = "id")
    val id: OrionID,
    @Json(name = "meta")
    val meta: Meta,
    @Json(name = "popularity")
    val popularity: Popularity,
    @Json(name = "time")
    val accessTime: ODAccessTime
)

@JsonClass(generateAdapter = true)
data class OrionRequests(
    @Json(name = "daily")
    val daily: Daily,
    @Json(name = "total")
    val total: Int
)

@JsonClass(generateAdapter = true)
data class OrionStream(
    @Json(name = "access")
    val access: Access,
    @Json(name = "audio")
    val audio: Audio,
    @Json(name = "file")
    val orionFile: OrionFile,
    @Json(name = "id")
    val id: String,
    @Json(name = "links")
    val links: List<String>,
    @Json(name = "meta")
    val meta: MetaX,
    @Json(name = "popularity")
    val popularity: PopularityX,
    @Json(name = "stream")
    val stream: StreamX,
    @Json(name = "subtitle")
    val subtitle: Subtitle,
    @Json(name = "time")
    val accessTime: ODAccessTime,
    @Json(name = "video")
    val video: Video
)

@JsonClass(generateAdapter = true)
data class OrionID(
    @Json(name = "imdb")
    val imdb: String,
    @Json(name = "orion")
    val orion: String,
    @Json(name = "tmdb")
    val tmdb: String
)

@JsonClass(generateAdapter = true)
data class Meta(
    @Json(name = "title")
    val title: String,
    @Json(name = "year")
    val year: Int
)

@JsonClass(generateAdapter = true)
data class Daily(
    @Json(name = "limit")
    val limit: Int,
    @Json(name = "remaining")
    val remaining: Int,
    @Json(name = "used")
    val used: Int
)

@JsonClass(generateAdapter = true)
data class Access(
    @Json(name = "direct")
    val direct: Boolean,
    @Json(name = "offcloud")
    val offcloud: Boolean,
    @Json(name = "premiumize")
    val premiumize: Boolean,
    @Json(name = "realdebrid")
    val realdebrid: Boolean
)

@JsonClass(generateAdapter = true)
data class Audio(
    @Json(name = "channels")
    val channels: Int,
    @Json(name = "codec")
    val codec: String,
    @Json(name = "languages")
    val languages: List<String>,
    @Json(name = "system")
    val system: String,
    @Json(name = "type")
    val type: String
)

@JsonClass(generateAdapter = true)
data class OrionFile(
    @Json(name = "hash")
    val hash: String,
    @Json(name = "name")
    val name: String,
    @Json(name = "pack")
    val pack: Boolean,
    @Json(name = "size")
    val size: Long
)

@JsonClass(generateAdapter = true)
data class MetaX(
    @Json(name = "edition")
    val edition: Any,
    @Json(name = "release")
    val release: String,
    @Json(name = "uploader")
    val uploader: String
)

@JsonClass(generateAdapter = true)
data class PopularityX(
    @Json(name = "count")
    val count: Int,
    @Json(name = "percent")
    val percent: Double
)

@JsonClass(generateAdapter = true)
data class StreamX(
    @Json(name = "hoster")
    val hoster: Any,
    @Json(name = "seeds")
    val seeds: Int,
    @Json(name = "source")
    val source: String,
    @Json(name = "time")
    val time: Int,
    @Json(name = "type")
    val type: String
)

@JsonClass(generateAdapter = true)
data class Subtitle(
    @Json(name = "languages")
    val languages: List<Any>,
    @Json(name = "type")
    val type: Any
)

@JsonClass(generateAdapter = true)
data class Video(
    @Json(name = "codec")
    val codec: String,
    @Json(name = "3d")
    val d: Boolean,
    @Json(name = "quality")
    val quality: String
)
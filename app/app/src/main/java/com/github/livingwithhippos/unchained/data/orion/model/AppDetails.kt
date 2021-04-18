package com.github.livingwithhippos.unchained.data.orion.model

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class AppDetails(
    @Json(name = "data")
    val appData: ODAppData,
    @Json(name = "name")
    val name: String,
    @Json(name = "result")
    val result: ODResult,
    @Json(name = "version")
    val version: String
)

@JsonClass(generateAdapter = true)
data class ODAppData(
    @Json(name = "description")
    val description: String,
    @Json(name = "id")
    val id: String,
    @Json(name = "link")
    val link: String,
    @Json(name = "logo")
    val logo: String,
    @Json(name = "name")
    val name: String,
    @Json(name = "popularity")
    val popularity: Popularity,
    @Json(name = "status")
    val status: String,
    @Json(name = "time")
    val time: ODTime,
    @Json(name = "type")
    val type: String
)

@JsonClass(generateAdapter = true)
data class ODResult(
    @Json(name = "status")
    val status: String
)

@JsonClass(generateAdapter = true)
data class Popularity(
    @Json(name = "count")
    val count: Int,
    @Json(name = "percent")
    val percent: Int
)

@JsonClass(generateAdapter = true)
data class ODTime(
    @Json(name = "added")
    val added: Int,
    @Json(name = "updated")
    val updated: Int
)
/*
{
  name: "Orion API",
  version: "3.0.0",
  result: {
    status: "success"
  },
  data: {
    id: "BBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBB",
    type: "addon",
    status: "active",
    name: "MyAddon",
    description: "My Kodi Addon",
    link: "https://myaddon.kodi",
    logo: "https://orionoid.com/logo/BBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBB",
    time: {
      added: 1528820858,
      updated: 1528820858
    },
    popularity: {
      count: 41,
      percent: 0.9323
    }
  }
}
*/
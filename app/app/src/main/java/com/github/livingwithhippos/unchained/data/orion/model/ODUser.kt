package com.github.livingwithhippos.unchained.data.orion.model
import com.squareup.moshi.JsonClass

import com.squareup.moshi.Json

@JsonClass(generateAdapter = true)
data class ODUser(
    @Json(name = "name")
    val name: String,
    @Json(name = "version")
    val version: String,
    @Json(name = "result")
    val result: ODResult,
    @Json(name = "data")
    val odData: ODUserData
)

@JsonClass(generateAdapter = true)
data class ODUserData(
    @Json(name = "id")
    val id: String,
    @Json(name = "key")
    val key: String,
    @Json(name = "email")
    val email: String?,
    @Json(name = "type")
    val type: String,
    @Json(name = "status")
    val status: String,
    @Json(name = "time")
    val accessTime: ODAccessTime,
    @Json(name = "subscription")
    val subscription: Subscription,
    @Json(name = "requests")
    val requests: ODUserRequests
)

@JsonClass(generateAdapter = true)
data class Subscription(
    @Json(name = "package")
    val packageX: Package,
    @Json(name = "time")
    val accessTime: ODDurationTime
)

@JsonClass(generateAdapter = true)
data class ODUserRequests(
    @Json(name = "count")
    val count: Int,
    @Json(name = "streams")
    val streams: ODUserQuota,
    @Json(name = "hashes")
    val hashes: ODUserQuota,
    @Json(name = "containers")
    val containers: ODUserQuota
)

@JsonClass(generateAdapter = true)
data class Package(
    @Json(name = "id")
    val id: String,
    @Json(name = "type")
    val type: String,
    @Json(name = "enabled")
    val enabled: Boolean,
    @Json(name = "internal")
    val `internal`: Boolean,
    @Json(name = "popular")
    val popular: Boolean,
    @Json(name = "name")
    val name: String,
    @Json(name = "description")
    val description: String,
    @Json(name = "limit")
    val limit: Limit,
    @Json(name = "gateway")
    val gateway: Gateway,
    @Json(name = "price")
    val price: Int
)

@JsonClass(generateAdapter = true)
data class Limit(
    @Json(name = "duration")
    val duration: Long,
    @Json(name = "streams")
    val streams: Int,
    @Json(name = "hashes")
    val hashes: Int,
    @Json(name = "containers")
    val containers: Int
)

@JsonClass(generateAdapter = true)
data class Gateway(
    @Json(name = "id")
    val id: String,
    @Json(name = "name")
    val name: String,
    @Json(name = "description")
    val description: String,
    @Json(name = "reseller")
    val reseller: Boolean
)

@JsonClass(generateAdapter = true)
data class ODUserQuota(
    @Json(name = "total")
    val total: Int,
    @Json(name = "daily")
    val daily: Daily
)

@JsonClass(generateAdapter = true)
data class ODDurationTime(
    @Json(name = "started")
    val started: Long,
    @Json(name = "expiration")
    val expiration: Long
)
package com.example.dto

import kotlinx.serialization.Serializable

@Serializable
data class YachtsResponse(
    val list: List<YachtDto>
)

@Serializable
data class YachtsLocationsResponse(
    val list: List<YachtLocationDto>
)

@Serializable
data class YachtDto(
    val id: Int,
    val name: String,
    val manufacturer: String,
    val length: Double,
    val crewNum: Int,
    val pricePerDay: Int,
    val imageUrl: String,
    val isAvailable: Boolean
)

@Serializable
data class YachtLocationDto(
    val id: Int,
    val name: String,
    val latitude: Double,
    val longitude: Double
)
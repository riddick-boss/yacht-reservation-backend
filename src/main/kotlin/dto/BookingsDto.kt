package com.example.dto

import kotlinx.serialization.Serializable

@Serializable
data class YachtBookingRequest(
    val yachtId: Int,
    val day: String
)

@Serializable
data class BookingsResponse(
    val list: List<BookingDto>
)

@Serializable
data class BookingDto(
    val id: Int,
    val yacht: YachtBookingDto,
    val day: String,
    val location: BookingLocationDto
)

@Serializable
data class YachtBookingDto(
    val name: String
)

@Serializable
data class BookingLocationDto(
    val name: String,
    val imageUrl: String
)
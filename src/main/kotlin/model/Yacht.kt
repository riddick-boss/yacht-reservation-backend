package com.example.model

data class Yacht(
    val id: Int,
    val name: String,
    val manufacturer: String,
    val length: Double,
    val crewNum: Int,
    val pricePerDay: Int,
    val imageUrl: String,
    val isAvailable: Boolean,
    val location: Location
) {
    data class Location(
        val latitude: Long,
        val longitude: Long
    )
}

package com.example.dto

import kotlinx.serialization.Serializable

@Serializable
data class AllYachtsResponse(
    val list: List<Yacht>
) {
    @Serializable
    data class Yacht(
        val id: Int,
        val name: String,
        val manufacturer: String,
        val length: Double,
        val crewNum: Int,
        val price: Int
    )
}
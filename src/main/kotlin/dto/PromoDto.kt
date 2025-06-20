package com.example.dto

import kotlinx.serialization.Serializable

@Serializable
data class PromoResponse(
    val yacht: YachtPromoDto,
    val location: String,
    val price: Int,
    val availableDays: List<String>
)

@Serializable
data class PromoBannerResponse(
    val title: String,
    val message: String,
    val buttonText: String
)

@Serializable
data class YachtPromoDto(
    val id: Int,
    val name: String,
    val imageUrl: String
)
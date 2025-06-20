package com.example.model

import java.time.LocalDate

data class PromoConfig(
    val banner: Banner,
    val discount: Float,
    val yachtId: Int,
    val locationId: Int,
    val dates: List<LocalDate>
) {
    data class Banner(
        val title: String,
        val message: String,
        val buttonText: String
    )
}
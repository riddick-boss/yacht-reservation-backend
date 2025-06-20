package com.example.infrastructure.impl

import com.example.dto.PromoBannerResponse
import com.example.infrastructure.PromoUtil
import com.example.model.PromoConfig
import java.time.LocalDate
import kotlin.random.Random

class PromoUtilImpl : PromoUtil {
    companion object {
        private val promoConfig = PromoConfig(
            banner = PromoConfig.Banner(
                title = "Summer Sale!",
                message = "Book now and get 20% off on our yachts.",
                buttonText = "Book now"
            ),
            discount = 0.8f,
            yachtId = Random.nextInt(1, 12),
            locationId = Random.nextInt(1, 6),
            dates = listOf(
                LocalDate.now().plusDays(Random.nextLong(1, 3)),
                LocalDate.now().plusDays(Random.nextLong(3, 12)),
                LocalDate.now().plusDays(Random.nextLong(12, 32)),
                LocalDate.now().plusDays(Random.nextLong(32, 69)),
            ),
        )
    }

    override fun getBannerData(): PromoBannerResponse {
        return PromoBannerResponse(
            title = promoConfig.banner.title,
            message = promoConfig.banner.message,
            buttonText = promoConfig.banner.buttonText
        )
    }

    override fun getPromoData(): PromoConfig {
        return promoConfig
    }
}
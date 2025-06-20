package com.example.services.promotion.impl

import com.example.dto.PromoBannerResponse
import com.example.dto.PromoResponse
import com.example.dto.YachtPromoDto
import com.example.infrastructure.PromoUtil
import com.example.repository.LocationRepository
import com.example.repository.YachtRepository
import com.example.services.promotion.PromoService

class PromoServiceImpl(
    private val promoUtil: PromoUtil,
    private val yachtRepository: YachtRepository,
    private val locationRepository: LocationRepository
) : PromoService {
    override fun getBannerData(): PromoBannerResponse = promoUtil.getBannerData()

    override fun getPromotion(): PromoResponse {
        val config = promoUtil.getPromoData()
        val yacht = yachtRepository.get(config.yachtId) ?: throw IllegalArgumentException("Invalid yachtId!")
        val location =
            locationRepository.get(config.locationId) ?: throw IllegalArgumentException("Invalid locationId!")
        val price = (yacht.pricePerDay * config.discount).toInt()
        val availableDates = config.dates.map { it.toString() }
        return PromoResponse(
            yacht = YachtPromoDto(
                id = yacht.id,
                name = yacht.name,
                imageUrl = yacht.imageUrl
            ),
            location = location.name,
            price = price,
            availableDays = availableDates
        )
    }
}
package com.example.services.promotion

import com.example.dto.PromoBannerResponse
import com.example.dto.PromoResponse

interface PromoService {
    fun getBannerData(): PromoBannerResponse
    fun getPromotion(): PromoResponse
}
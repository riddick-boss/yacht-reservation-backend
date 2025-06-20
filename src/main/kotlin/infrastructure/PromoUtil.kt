package com.example.infrastructure

import com.example.dto.PromoBannerResponse
import com.example.model.PromoConfig

interface PromoUtil {
    fun getBannerData(): PromoBannerResponse
    fun getPromoData(): PromoConfig
}
package com.example.routes

import com.example.services.promotion.PromoService
import io.ktor.server.application.Application
import io.ktor.server.response.respond
import io.ktor.server.routing.get
import io.ktor.server.routing.route
import io.ktor.server.routing.routing
import org.koin.ktor.ext.inject

fun Application.promotionRoutes() {
    val promoService by inject<PromoService>()
    routing {
        route("/promotion") {
            get("/banner") {
                val response = promoService.getBannerData()
                call.respond(response)
            }
            get {
                val response = promoService.getPromotion()
                call.respond(response)
            }
        }
    }
}
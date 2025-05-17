package com.example.config

import com.example.routes.authRoutes
import com.example.routes.yachtRoutes
import io.ktor.server.application.Application

fun Application.configureRouting() {
    authRoutes()
    yachtRoutes()
}
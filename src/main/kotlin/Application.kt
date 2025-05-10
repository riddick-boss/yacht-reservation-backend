package com.example

import com.example.config.configureContentNegotiation
import com.example.config.configureJWTSecurity
import com.example.config.configureKoin
import com.example.config.configureMonitoring
import com.example.config.configureRouting
import com.example.config.configureStatusPages
import com.example.config.configureSwagger
import io.ktor.server.application.Application
import io.ktor.server.netty.EngineMain

fun main(args: Array<String>) {
    EngineMain.main(args)
}

fun Application.module() {
    configureKoin()
    configureSwagger()
    configureMonitoring()
    configureContentNegotiation()
    configureJWTSecurity()
    configureStatusPages()
    configureRouting()
}

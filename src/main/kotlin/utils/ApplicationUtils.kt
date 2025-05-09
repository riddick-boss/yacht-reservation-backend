package com.example.utils

import io.ktor.server.application.Application

fun Application.getConfigString(path: String): String = environment.config.property(path).getString()
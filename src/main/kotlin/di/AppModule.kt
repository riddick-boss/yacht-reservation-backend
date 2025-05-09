package com.example.di

import com.example.servicees.auth.JwtService
import com.example.servicees.auth.impl.JwtServiceImpl
import org.koin.dsl.module

val appModule = module {
    single<JwtService> { JwtServiceImpl() }
}
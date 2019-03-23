package com.bast.weatherapp.remote

import androidx.annotation.NonNull
import retrofit2.Retrofit
import kotlin.reflect.KClass

class ServiceGenerator{

    @NonNull
    fun <S : Any> createService(retrofit: Retrofit, service: KClass<S>): S = retrofit.create( service.java )
}
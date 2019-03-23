package com.bast.weatherapp.remote


import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import java.util.concurrent.TimeUnit

class OpenWeatherRetrofitGenerator : RetrofitGenerator {

    private val logger = HttpLoggingInterceptor()

    init {
        logger.level = HttpLoggingInterceptor.Level.BODY
    }

    override fun retrofit(): Retrofit {
        val clientBuilder = OkHttpClient.Builder()
            .connectTimeout( 15000, TimeUnit.MILLISECONDS )
            .readTimeout( 40000, TimeUnit.MILLISECONDS )
            .addInterceptor(OpenWeatherInterceptor())
            .addInterceptor( logger )

        return Retrofit.Builder()
            .client( clientBuilder.build() )
            .addConverterFactory( MoshiConverterFactory.create(
                Moshi.Builder().add( KotlinJsonAdapterFactory() ).build() ) )
            .baseUrl( "https://api.openweathermap.org")
            .build()
    }
}
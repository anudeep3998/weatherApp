package com.bast.weatherapp.data

import com.bast.weatherapp.remote.OnCompleteListener
import com.bast.weatherapp.remote.models.ForecastResponse

interface ForecastService {

    fun cityName( cityName: String, units: String, listener: OnCompleteListener<ForecastResponse>)

    fun cityId( cityId: Long, units: String, listener: OnCompleteListener<ForecastResponse>)

    fun zip( zip: String, units: String, listener: OnCompleteListener<ForecastResponse>)

    fun latLon(  lat: Double, lon: Double, units: String, listener: OnCompleteListener<ForecastResponse>)
}
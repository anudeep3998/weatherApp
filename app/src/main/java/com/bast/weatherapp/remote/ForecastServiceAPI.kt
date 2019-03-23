package com.bast.weatherapp.remote

import com.bast.weatherapp.remote.models.ForecastResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

@Suppress("unused")
interface ForecastServiceAPI {

    @GET(value = "/data/2.5/forecast")
    fun cityName( @Query(value = "q") cityName: String, @Query(value = "units") units: String ) : Call<ForecastResponse>

    @GET(value = "/data/2.5/forecast")
    fun cityId( @Query(value = "id") cityId: Long, @Query(value = "units") units: String ) : Call<ForecastResponse>

    @GET(value = "/data/2.5/forecast")
    fun zip( @Query(value = "zip") zip: String, @Query(value = "units") units: String ) : Call<ForecastResponse>

    @GET(value = "/data/2.5/forecast")
    fun latLon( @Query(value = "lat") lat: Double, @Query(value = "lon") lon: Double, @Query(value = "units") units: String ) : Call<ForecastResponse>
}
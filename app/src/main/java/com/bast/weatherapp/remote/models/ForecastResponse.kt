package com.bast.weatherapp.remote.models

import com.squareup.moshi.Json

data class ForecastResponse ( @Json(name = "city") val city: City,
                              @Json(name = "list") val list: List<Forecast> )
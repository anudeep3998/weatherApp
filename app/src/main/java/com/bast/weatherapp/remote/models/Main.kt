package com.bast.weatherapp.remote.models

import com.squareup.moshi.Json

data class Main ( @Json(name = "temp") val temp: Double?,
                  @Json(name = "temp_min") val tempMin: Double?,
                  @Json(name = "temp_max") val tempMax: Double?,
                  @Json(name = "pressure") val pressure: Double?,
                  @Json(name = "sea_level") val seaLevel: Double?,
                  @Json(name = "grnd_level") val groundLevel: Double?,
                  @Json(name = "humidity") val humidity: Double? )
package com.bast.weatherapp.remote.models

import com.squareup.moshi.Json

data class Forecast ( @Json(name = "dt") val dateTime: Long?,
                      @Json(name = "main") val main: Main?,
                      @Json(name = "weather") val weather: List<Weather>?,
                      @Json(name = "clouds") val clouds: Clouds?,
                      @Json(name = "wind") val wind: Wind?,
                      @Json(name = "rain") val rain: Rain?,
                      @Json(name = "snow") val snow: Snow? )
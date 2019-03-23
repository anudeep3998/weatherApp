package com.bast.weatherapp.remote.models

import com.squareup.moshi.Json

data class Coordinate ( @Json(name = "lat") val lat: Double?,
                        @Json(name = "lon") val lon: Double? )
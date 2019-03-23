package com.bast.weatherapp.remote.models

import com.squareup.moshi.Json

data class Wind ( @Json(name = "speed") val speed: Double?,
                  @Json(name = "deg") val deg: Double? )
package com.bast.weatherapp.remote.models

import com.squareup.moshi.Json

data class Weather ( @Json(name = "id") val id: Long?,
                     @Json(name = "main") val main: String?,
                     @Json(name = "description") val description: String?,
                     @Json(name = "icon") val icon: String? )
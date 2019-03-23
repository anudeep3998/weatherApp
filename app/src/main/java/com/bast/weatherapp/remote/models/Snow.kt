package com.bast.weatherapp.remote.models

import com.squareup.moshi.Json

data class Snow ( @Json(name = "3h") val amount: Double? )
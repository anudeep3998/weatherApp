package com.bast.weatherapp.remote.models

import com.squareup.moshi.Json

data class Rain ( @Json(name = "3h") val amount: Double? )
package com.bast.weatherapp.remote.models

import com.squareup.moshi.Json

data class Clouds ( @Json(name = "all") val all: Double? )
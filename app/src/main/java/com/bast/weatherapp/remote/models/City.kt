package com.bast.weatherapp.remote.models

import com.squareup.moshi.Json

data class City ( @Json(name = "id") val id: Long?,
                  @Json(name = "name") val name: String?,
                  @Json(name = "coord") val coordinate: Coordinate? )
package com.bast.weatherapp.ui

data class ForecastRequestDataItem ( val type: RequestType,
                                     val name: String? = null,
                                     val id: Long? = null,
                                     val lat: Double? = null,
                                     val lon: Double? = null )

enum class RequestType { CITY_NAME_SEARCH, CITY_ID_SEARCH, LAT_LON_SEARCH, ZIP_SEARCH }
package com.bast.weatherapp.data.mappers

import com.bast.weatherapp.data.EntityMapper
import com.bast.weatherapp.data.models.Humidity
import com.bast.weatherapp.remote.models.Forecast

class HumidityMapper: EntityMapper<Forecast?, Humidity?> {
    override fun map(value: Forecast?): Humidity? {
        val main = value?.main
        val humidity = main?.humidity

        return if( humidity != null ) Humidity( humidity ) else null
    }
}
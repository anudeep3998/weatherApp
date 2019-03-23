package com.bast.weatherapp.data.mappers

import com.bast.weatherapp.data.EntityMapper
import com.bast.weatherapp.data.models.Temperature
import com.bast.weatherapp.remote.models.Forecast

class TemperatureMapper: EntityMapper<Forecast?, Temperature?> {
    override fun map(value: Forecast?): Temperature? {
        val main = value?.main
        val temperature = main?.temp
        val maxTemperature = main?.tempMax
        val minTemperature = main?.tempMin

        return if( temperature == null || maxTemperature == null || minTemperature == null )
            null
        else
            Temperature( temperature, minTemperature, maxTemperature )
    }
}
package com.bast.weatherapp.data.mappers

import com.bast.weatherapp.data.EntityMapper
import com.bast.weatherapp.data.models.Pressure
import com.bast.weatherapp.remote.models.Forecast

class PressureMapper : EntityMapper<Forecast?, Pressure?> {
    override fun map(value: Forecast?): Pressure? {
        val main = value?.main
        val pressure = main?.pressure
        val seaLevel = main?.seaLevel
        val groundLevel = main?.groundLevel

        return if( pressure == null || seaLevel == null || groundLevel == null )
            null
        else
            Pressure( pressure, seaLevel, groundLevel )
    }
}
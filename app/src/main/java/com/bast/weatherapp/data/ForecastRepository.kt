package com.bast.weatherapp.data

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.bast.weatherapp.remote.ForecastRemoteServiceImpl
import com.bast.weatherapp.remote.OnCompleteListener
import com.bast.weatherapp.remote.OpenWeatherRetrofitGenerator
import com.bast.weatherapp.remote.models.ForecastResponse

class ForecastRepository {

    private val service: ForecastService by lazy { ForecastRemoteServiceImpl( OpenWeatherRetrofitGenerator () ) }

    fun cityName( cityName: String ) : LiveData<ForecastResponse> {
       val data = MutableLiveData<ForecastResponse>()

        service.cityName( cityName, "metric", object : OnCompleteListener<ForecastResponse> {
            override fun onComplete(value: ForecastResponse?) {
                data.value = value
            }
        })

        return data
    }

    fun cityId( cityId: Long ) : LiveData<ForecastResponse> {
        val data = MutableLiveData<ForecastResponse>()

        service.cityId( cityId, "metric", object : OnCompleteListener<ForecastResponse> {
            override fun onComplete(value: ForecastResponse?) {
                data.value = value
            }
        })

        return data
    }

    fun zip( zip: String ) : LiveData<ForecastResponse> {
        val data = MutableLiveData<ForecastResponse>()

        service.zip( zip, "metric", object : OnCompleteListener<ForecastResponse> {
            override fun onComplete(value: ForecastResponse?) {
                data.value = value
            }
        })

        return data
    }

    fun latLon(  lat: Double, lon: Double ) : LiveData<ForecastResponse> {
        val data = MutableLiveData<ForecastResponse>()

        service.latLon( lat, lon, "metric", object : OnCompleteListener<ForecastResponse> {
            override fun onComplete(value: ForecastResponse?) {
                data.value = value
            }
        })

        return data
    }
}
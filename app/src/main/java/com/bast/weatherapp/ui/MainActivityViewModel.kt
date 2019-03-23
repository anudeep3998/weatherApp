package com.bast.weatherapp.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Transformations
import androidx.lifecycle.ViewModel
import com.bast.weatherapp.data.ForecastRepository
import com.bast.weatherapp.remote.models.ForecastResponse

class MainActivityViewModel: ViewModel(){

    private val repository: ForecastRepository by lazy { ForecastRepository() }

    private val request: MutableLiveData<ForecastRequestDataItem> = MutableLiveData()

    private val forecast: LiveData<ForecastResponse> = Transformations.switchMap( request ) {
        when( it.type ) {
            RequestType.CITY_NAME_SEARCH -> repository.cityName( it.name!! )
            RequestType.CITY_ID_SEARCH -> repository.cityId( it.id!! )
            RequestType.LAT_LON_SEARCH -> repository.latLon( it.lat!!, it.lon!! )
            RequestType.ZIP_SEARCH -> repository.zip( it.name!! )
        }
    }

    fun forecast() : LiveData<ForecastResponse> {
        return forecast
    }

    fun request( request: ForecastRequestDataItem ) {
        this.request.value = request
    }
}
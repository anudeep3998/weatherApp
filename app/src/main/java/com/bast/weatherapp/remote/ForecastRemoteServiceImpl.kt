package com.bast.weatherapp.remote

import com.bast.weatherapp.data.ForecastService
import com.bast.weatherapp.remote.models.ForecastResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import timber.log.Timber

class ForecastRemoteServiceImpl( private val retrofitGenerator: RetrofitGenerator ): ForecastService {

    private lateinit var call: Call<ForecastResponse>

    override fun cityName(cityName: String, units: String, listener: OnCompleteListener<ForecastResponse>) {
        try {
            call = ServiceGenerator().createService( retrofitGenerator.retrofit(), ForecastServiceAPI::class )
                .cityName( cityName, units )

            call.enqueue(object : Callback<ForecastResponse> {
                override fun onFailure(call: Call<ForecastResponse>, t: Throwable) {
                    Timber.d("Couldn't get by cityName : $t")

                    listener.onComplete( null )
                }

                override fun onResponse(call: Call<ForecastResponse>, response: Response<ForecastResponse>) {
                    if( response.isSuccessful ) {
                        listener.onComplete( response.body() )
                    } else {
                        Timber.d("Couldn't get by cityName : ${response.errorBody()?.string()}")

                        listener.onComplete( null )
                    }
                }
            })
        } catch (e: Exception) {
            Timber.d("Couldn't get by cityName : $e")

            listener.onComplete( null )
        }
    }

    override fun cityId(cityId: Long, units: String, listener: OnCompleteListener<ForecastResponse>) {
        try {
            call = ServiceGenerator().createService( retrofitGenerator.retrofit(), ForecastServiceAPI::class )
                .cityId( cityId, units )

            call.enqueue(object : Callback<ForecastResponse> {
                override fun onFailure(call: Call<ForecastResponse>, t: Throwable) {
                    Timber.d("Couldn't get by cityId : $t")

                    listener.onComplete( null )
                }

                override fun onResponse(call: Call<ForecastResponse>, response: Response<ForecastResponse>) {
                    if( response.isSuccessful ) {
                        listener.onComplete( response.body() )
                    } else {
                        Timber.d("Couldn't get by cityId : ${response.errorBody()?.string()}")

                        listener.onComplete( null )
                    }
                }
            })
        } catch (e: Exception) {
            Timber.d("Couldn't get by cityId : $e")

            listener.onComplete( null )
        }
    }

    override fun zip(zip: String, units: String, listener: OnCompleteListener<ForecastResponse>) {
        try {
            call = ServiceGenerator().createService( retrofitGenerator.retrofit(), ForecastServiceAPI::class )
                .zip( zip, units )

            call.enqueue(object : Callback<ForecastResponse> {
                override fun onFailure(call: Call<ForecastResponse>, t: Throwable) {
                    Timber.d("Couldn't get by zip : $t")

                    listener.onComplete( null )
                }

                override fun onResponse(call: Call<ForecastResponse>, response: Response<ForecastResponse>) {
                    if( response.isSuccessful ) {
                        listener.onComplete( response.body() )
                    } else {
                        Timber.d("Couldn't get by zip : ${response.errorBody()?.string()}")

                        listener.onComplete( null )
                    }
                }
            })
        } catch (e: Exception) {
            Timber.d("Couldn't get by zip : $e")

            listener.onComplete( null )
        }
    }

    override fun latLon(lat: Double, lon: Double, units: String, listener: OnCompleteListener<ForecastResponse>) {
        try {
            call = ServiceGenerator().createService( retrofitGenerator.retrofit(), ForecastServiceAPI::class )
                .latLon( lat, lon, units )

            call.enqueue(object : Callback<ForecastResponse> {
                override fun onFailure(call: Call<ForecastResponse>, t: Throwable) {
                    Timber.d("Couldn't get by latLon : $t")

                    listener.onComplete( null )
                }

                override fun onResponse(call: Call<ForecastResponse>, response: Response<ForecastResponse>) {
                    if( response.isSuccessful ) {
                        listener.onComplete( response.body() )
                    } else {
                        Timber.d("Couldn't get by latLon : ${response.errorBody()?.string()}")

                        listener.onComplete( null )
                    }
                }
            })
        } catch (e: Exception) {
            Timber.d("Couldn't get by latLon : $e")

            listener.onComplete( null )
        }
    }
}
package com.bast.weatherapp.remote

import okhttp3.Interceptor
import okhttp3.Response

class OpenWeatherInterceptor: Interceptor {

    override fun intercept(chain: Interceptor.Chain): Response {
        val original = chain.request()
        val originalHttpUrl = original.url()

        val url = originalHttpUrl.newBuilder()
            .addQueryParameter("appid", "3ad39ea89c4847d57d420ca34091683d")
            .build()

        return chain.proceed( original
            .newBuilder().url(url).build() )
    }
}
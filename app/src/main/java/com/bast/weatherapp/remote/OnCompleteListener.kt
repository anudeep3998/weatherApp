package com.bast.weatherapp.remote

interface OnCompleteListener<T> {
    fun onComplete( value : T? )
}
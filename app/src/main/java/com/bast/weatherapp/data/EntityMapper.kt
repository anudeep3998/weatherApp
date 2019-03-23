package com.bast.weatherapp.data

interface EntityMapper<S,T> {
    fun map( value: S ) : T
}
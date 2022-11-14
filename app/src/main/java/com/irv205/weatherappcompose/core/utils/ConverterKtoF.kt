package com.irv205.weatherappcompose.core.utils

import kotlin.math.ceil

fun convertKelvinStringToFahrenheitString(kelvin: String): String{
    return try {
        val k = kelvin.toDouble()
        val fahrenheit = ceil(((k - 273.5) * 9/5 + 32)).toInt()
        fahrenheit.toString()
    } catch (e: Exception) {
        "Not a valid degree"
    }
}
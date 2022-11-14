package com.irv205.weatherappcompose.core.utils

import kotlin.math.ceil

fun converKelvinToFahrenheit(kelvin: String): String{
    val k = kelvin.toDouble()
    val fahrenheit = ceil(((k - 273.5) * 9/5 + 32)).toInt()
    return fahrenheit.toString()
}
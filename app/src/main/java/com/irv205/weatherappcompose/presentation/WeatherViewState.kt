package com.irv205.weatherappcompose.presentation

sealed class WeatherViewState {
    object HomeView : WeatherViewState()
    class Error(val message: String) : WeatherViewState()
}
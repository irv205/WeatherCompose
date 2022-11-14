package com.irv205.weatherappcompose.presentation.navigation

sealed class NavigationWeatherViews(val route: String){
    object HomeView : NavigationWeatherViews("home_view")
    object DetailView : NavigationWeatherViews("detail_view")
    object MoreDetails : NavigationWeatherViews("more_details")
}

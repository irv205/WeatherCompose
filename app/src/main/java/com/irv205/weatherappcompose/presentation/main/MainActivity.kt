package com.irv205.weatherappcompose.presentation.main

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.irv205.weatherappcompose.presentation.WeatherViewModel
import com.irv205.weatherappcompose.presentation.details.DetailView
import com.irv205.weatherappcompose.presentation.home.HomeView
import com.irv205.weatherappcompose.presentation.moredetails.MoreDetails
import com.irv205.weatherappcompose.presentation.navigation.NavigationWeatherViews
import com.irv205.weatherappcompose.ui.theme.WeatherAppComposeTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            WeatherAppComposeTheme {
                val navController = rememberNavController()
                val vm: WeatherViewModel = viewModel()
                NavHost(
                    navController = navController, startDestination = NavigationWeatherViews.HomeView.route){
                    composable(NavigationWeatherViews.HomeView.route) {
                        HomeView(vm){ navController.navigate(NavigationWeatherViews.DetailView.route) }
                    }
                    composable(NavigationWeatherViews.DetailView.route) {
                        DetailView(vm, onItemClick = {
                            navController.navigate(NavigationWeatherViews.MoreDetails.route)
                        }, onBackHome = {
                            navController.navigate(NavigationWeatherViews.HomeView.route) {
                                popUpTo(NavigationWeatherViews.HomeView.route)
                                launchSingleTop = true
                            }
                        })
                    }
                    composable(NavigationWeatherViews.MoreDetails.route) {
                        MoreDetails(vm) { navController.navigate(NavigationWeatherViews.DetailView.route) }
                    }
                }
            }
        }
    }
}

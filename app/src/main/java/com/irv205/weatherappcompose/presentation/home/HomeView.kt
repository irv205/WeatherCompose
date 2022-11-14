package com.irv205.weatherappcompose.presentation.home

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.irv205.weatherappcompose.R
import com.irv205.weatherappcompose.presentation.WeatherViewModel
import com.irv205.weatherappcompose.presentation.WeatherViewState
import com.irv205.weatherappcompose.presentation.main.DisplayContent

@Composable
fun HomeView(vm : WeatherViewModel, navigateToDetails : () -> Unit){

    val viewState = remember { vm.viewState }
    val inputValue = remember { vm.inputValue }

    when(val view = viewState.value){
        is WeatherViewState.Error -> {
            DisplayContent(modifier = Modifier, title = "Error", body = view.message) {
                vm.switchViews(view = WeatherViewState.HomeView)
            }
        }
        WeatherViewState.HomeView -> {
            HomeBody(inputValue.value, onInputChanged = { vm.setInputValue(it)}, onBtnClick = {
                vm.getWeatherList(it) }, navigateToDetails = {navigateToDetails.invoke()})
        }
    }
}

@Composable
fun HomeBody(inputValue: String, navigateToDetails : () -> Unit, onInputChanged : (String) -> Unit, onBtnClick : (() -> Unit) -> Unit){

    Column(modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        TextField(
            value = inputValue,
            onValueChange = { onInputChanged(it) },
        )

        Spacer(modifier = Modifier.size(8.dp))

        Button(modifier = Modifier,
            onClick = {
                onBtnClick{
                    navigateToDetails.invoke()
                }
            },
            border = BorderStroke(1.dp, Color.Gray),
            colors = ButtonDefaults.outlinedButtonColors(contentColor = Color.Gray)
        ) {
            Text(text = stringResource(id = R.string.home_btn), color = Color.Gray, maxLines = 1)
        }
    }
}

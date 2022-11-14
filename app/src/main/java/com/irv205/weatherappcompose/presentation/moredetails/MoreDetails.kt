package com.irv205.weatherappcompose.presentation.moredetails

import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.irv205.weatherappcompose.R
import com.irv205.weatherappcompose.core.utils.convertKelvinStringToFahrenheitString
import com.irv205.weatherappcompose.domain.DomainWeather
import com.irv205.weatherappcompose.presentation.WeatherViewModel
import com.irv205.weatherappcompose.presentation.main.HeaderView

@Composable
fun MoreDetails(vm : WeatherViewModel, navigateBack : () -> Unit) {

    val weather = remember { vm.selectedWeather }

    weather.value?.let {
        BodyDetails(domainWeather = it, city = vm.inputValue.value) {
            navigateBack.invoke()
        }
    }

}

@Composable
fun BodyDetails(domainWeather: DomainWeather, city: String, navigateBack: () -> Unit) {

    Scaffold(modifier = Modifier.fillMaxSize(), topBar = { HeaderView(title = city) {
        navigateBack.invoke()
    } }) {
        Column(modifier = Modifier
            .fillMaxSize()
            .padding(it),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(text = stringResource(id = R.string.more_details_temp, convertKelvinStringToFahrenheitString(domainWeather.temp)), style = MaterialTheme.typography.h1)
            Text(modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp, 0.dp),
                text = stringResource(id = R.string.more_details_feels_like, convertKelvinStringToFahrenheitString(domainWeather.feels_like)), style = MaterialTheme.typography.body1, textAlign = TextAlign.End)
            Spacer(modifier = Modifier.size(32.dp))
            Text(modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp, 0.dp),
                text = domainWeather.weather, style = MaterialTheme.typography.h5, textAlign = TextAlign.Start)
            Text(modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp, 0.dp),text = domainWeather.weather_description, style = MaterialTheme.typography.h6, textAlign = TextAlign.Start)
        }
    }
}
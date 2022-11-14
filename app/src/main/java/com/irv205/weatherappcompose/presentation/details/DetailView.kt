package com.irv205.weatherappcompose.presentation.details

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Divider
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.irv205.weatherappcompose.R
import com.irv205.weatherappcompose.core.utils.convertKelvinStringToFahrenheitString
import com.irv205.weatherappcompose.domain.DomainWeather
import com.irv205.weatherappcompose.presentation.WeatherViewModel
import com.irv205.weatherappcompose.presentation.main.HeaderView

@Composable
fun DetailView(vm: WeatherViewModel, onItemClick: () -> Unit, onBackHome : () -> Unit){

    val list = remember { vm.list }
    ListDetailsView(listL = list, city = vm.inputValue.value, onBackHome = { onBackHome.invoke() }, onItemClick = { onItemClick.invoke()
        vm.setSelectedWeather(it)})
}

@Composable
fun ListDetailsView(modifier: Modifier = Modifier, listL: List<DomainWeather> = emptyList(), city: String, onItemClick: (DomainWeather) -> Unit, onBackHome: () -> Unit){

    Scaffold(modifier = modifier.fillMaxSize(), topBar = { HeaderView(title = city) {
        onBackHome.invoke()
    } }) {
        LazyColumn(modifier = Modifier){
            items(listL) { item ->
                Divider(color = MaterialTheme.colors.onBackground)
                ItemForecast(modifier = modifier, domainWeather = item){
                    onItemClick(it)
                }
            }
        }
    }
}

@Composable
fun ItemForecast(modifier: Modifier = Modifier, domainWeather: DomainWeather, onItemClick: (DomainWeather) -> Unit) {

    Box(modifier = Modifier.fillMaxWidth()) {
        Row(
            modifier = Modifier
                .align(Alignment.Center)
                .fillMaxWidth()
                .padding(10.dp)
                .clickable {
                    onItemClick(domainWeather)
                },
            horizontalArrangement = Arrangement.SpaceEvenly) {
            Text(text = domainWeather.weather)
            Text(text = stringResource(id = R.string.item_temp, convertKelvinStringToFahrenheitString(domainWeather.temp)))
        }
    }

}


package com.irv205.weatherappcompose.presentation

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.snapshots.SnapshotStateList
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.irv205.weatherappcompose.domain.DomainResponse
import com.irv205.weatherappcompose.domain.DomainWeather
import com.irv205.weatherappcompose.domain.repository.ForecastRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject

@HiltViewModel
class WeatherViewModel @Inject constructor(private val repository: ForecastRepository): ViewModel() {

    private val _list = mutableStateListOf<DomainWeather>()
    val list : SnapshotStateList<DomainWeather> get() = _list

    private val _inputValue = mutableStateOf("")
    val inputValue : State<String> get() = _inputValue

    private val _selectedWeather = mutableStateOf<DomainWeather?>(null)
    val selectedWeather : State<DomainWeather?> get() = _selectedWeather

    private val _viewStates = mutableStateOf<WeatherViewState>(WeatherViewState.HomeView)
    val viewState : State<WeatherViewState> get() = _viewStates

    fun switchViews(view: WeatherViewState){
        _viewStates.value = view
    }

    fun setSelectedWeather(domainWeather: DomainWeather) {
        _selectedWeather.value = domainWeather
    }

    fun setInputValue(input: String) {
        _inputValue.value = input
    }

    fun getWeatherList(navigateToDetails : () -> Unit) {
        if (_inputValue.value.isNotEmpty()) {
            viewModelScope.launch(Dispatchers.IO) {
                when(val result = repository.getForecast(_inputValue.value)){
                    is DomainResponse.OnFailure -> {
                        withContext(Dispatchers.Main) {
                            switchViews(WeatherViewState.Error(result.message))
                        }
                    }
                    is DomainResponse.Success -> {
                        withContext(Dispatchers.Main) {
                            _list.clear()
                            _list.addAll(result.data)
                            if (_list.isNotEmpty()) navigateToDetails.invoke()
                        }
                    }
                }
            }
        }
    }

}
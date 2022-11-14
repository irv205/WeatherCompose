package com.irv205.weatherappcompose.data.repository

import com.irv205.weatherappcompose.R
import com.irv205.weatherappcompose.domain.service.ForecastNetworkDataSource
import com.irv205.weatherappcompose.domain.DomainResponse
import com.irv205.weatherappcompose.domain.DomainWeather
import com.irv205.weatherappcompose.domain.StringProvider
import com.irv205.weatherappcompose.domain.repository.ForecastRepository
import javax.inject.Inject

class ForecastRepositoryImp @Inject constructor(private val networkDataSource: ForecastNetworkDataSource, private val stringProvider: StringProvider): ForecastRepository {

    override suspend fun getForecast(city: String): DomainResponse<List<DomainWeather>> {
       return try {
           networkDataSource.getForecast(city)
       } catch (e: Exception){
           DomainResponse.OnFailure(stringProvider.getString(R.string.error_404))
       }
    }
}
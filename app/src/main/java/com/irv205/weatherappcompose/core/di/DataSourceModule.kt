package com.irv205.weatherappcompose.core.di

import com.irv205.weatherappcompose.data.networkdatasource.ForecastNetworkDataSourceImp
import com.irv205.weatherappcompose.domain.service.ForecastNetworkDataSource
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class DataSourceModule{
    @Binds
    abstract fun provideForecastNetworkSource(forecastNetworkDataSourceImp: ForecastNetworkDataSourceImp): ForecastNetworkDataSource
}
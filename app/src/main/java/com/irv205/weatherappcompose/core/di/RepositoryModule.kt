package com.irv205.weatherappcompose.core.di

import com.irv205.weatherappcompose.domain.service.ForecastNetworkDataSource
import com.irv205.weatherappcompose.data.networkdatasource.ForecastNetworkDataSourceImp
import com.irv205.weatherappcompose.domain.repository.ForecastRepository
import com.irv205.weatherappcompose.data.repository.ForecastRepositoryImp
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {
    @Binds
    abstract fun provideForecastRepository(forecastRepository: ForecastRepositoryImp): ForecastRepository

}
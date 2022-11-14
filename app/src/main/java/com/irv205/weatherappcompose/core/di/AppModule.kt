package com.irv205.weatherappcompose.core.di

import com.irv205.weatherappcompose.domain.StringProvider
import com.irv205.weatherappcompose.domain.framework.StringProviderImp
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class AppModule{

    @Binds
    abstract fun bindStringProvider(stringProviderImp: StringProviderImp): StringProvider
}
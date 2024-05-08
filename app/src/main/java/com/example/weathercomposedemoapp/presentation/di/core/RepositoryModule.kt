package com.example.weathercomposedemoapp.presentation.di.core

import com.example.weathercomposedemoapp.data.repository.city.getAMSCityListRepositoryImpl
import com.example.weathercomposedemoapp.data.repository.city.getOWCityListRepositoryImpl
import com.example.weathercomposedemoapp.data.repository.city.getWACityListRepositoryImpl
import com.example.weathercomposedemoapp.data.repository.weather.getAMSWeatherRepositoryImpl
import com.example.weathercomposedemoapp.data.repository.weather.getOWWeatherRepositoryImpl
import com.example.weathercomposedemoapp.data.repository.weather.getWAWeatherRepositoryImpl
import com.example.weathercomposedemoapp.domain.repository.CityRepository
import com.example.weathercomposedemoapp.domain.repository.WeatherRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Named
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class RepositoryModule {
    @Singleton
    @Provides
    @Named("WAWeather")
    fun provideWAWeatherRepository(): WeatherRepository {
        return getWAWeatherRepositoryImpl()
    }

    @Singleton
    @Provides
    @Named("OWWeather")
    fun provideOWWeatherRepository(): WeatherRepository {
        return getOWWeatherRepositoryImpl()
    }

    @Singleton
    @Provides
    @Named("AMSWeather")
    fun provideAMSWeatherRepository(): WeatherRepository {
        return getAMSWeatherRepositoryImpl()
    }

    @Singleton
    @Provides
    @Named("WACity")
    fun provideWACityListRepository(
    ): CityRepository {
        return getWACityListRepositoryImpl()
    }

    @Singleton
    @Provides
    @Named("OWCity")
    fun provideOWCityListRepository(
    ): CityRepository {
        return getOWCityListRepositoryImpl()
    }

    @Singleton
    @Provides
    @Named("AMSCity")
    fun provideAMSCityListRepository(
    ): CityRepository {
        return getAMSCityListRepositoryImpl()
    }
}
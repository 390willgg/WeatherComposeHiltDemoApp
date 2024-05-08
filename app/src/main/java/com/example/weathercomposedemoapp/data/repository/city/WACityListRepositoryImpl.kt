package com.example.weathercomposedemoapp.data.repository.city

import com.example.weathercomposedemoapp.data.model.format.CityWeatherData
import com.example.weathercomposedemoapp.data.repository.city.dataSource.CityListRemoteDataSource
import com.example.weathercomposedemoapp.data.repository.city.dataSourceImpl.getWACityListRemoteDataSourceImpl
import com.example.weathercomposedemoapp.domain.repository.CityRepository
import okhttp3.OkHttpClient

private class WACityListRepositoryImpl: CityRepository {
    private val apiKey = "2ecdf6cfe5msh105a2f4e752782fp12c102jsnfc8c7fda92cc"
    private val client = OkHttpClient.Builder().addInterceptor { chain ->
        val original = chain.request()
        val requestBuilder = original.newBuilder()
        requestBuilder.addHeader("X-RapidAPI-Key", apiKey)
        requestBuilder.addHeader("X-RapidAPI-Host", "weatherapi-com.p.rapidapi.com")

        val request = requestBuilder.build()
        chain.proceed(request)
    }.build()

    val cityListRemoteDataSource: CityListRemoteDataSource = getWACityListRemoteDataSourceImpl(client)
    override suspend fun getCitiesList(cityName: String, limit: Int): CityWeatherData? {
        return cityListRemoteDataSource.getCities(cityName, limit)
    }
}

fun getWACityListRepositoryImpl(): CityRepository {
    return WACityListRepositoryImpl()
}
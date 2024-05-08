package com.example.weathercomposedemoapp.presentation.view.city

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import com.example.weathercomposedemoapp.data.model.format.CityWeatherData
import com.example.weathercomposedemoapp.domain.useCase.city.CitiesListUseCase
import com.example.weathercomposedemoapp.presentation.ApiProviderOptions
import dagger.assisted.Assisted
import dagger.assisted.AssistedFactory
import dagger.assisted.AssistedInject
import kotlinx.coroutines.cancelChildren
import kotlinx.coroutines.launch

@Suppress("UNCHECKED_CAST")
class CityViewModel @AssistedInject constructor(
    @Assisted private val apiProviderOptiosn: ApiProviderOptions,
    private val citiesListUseCase: CitiesListUseCase
): ViewModel() {

    @AssistedFactory
    interface Factory {
        fun create(apiProviderOptions: ApiProviderOptions): CityViewModel
    }

    companion object{
        fun provideCityViewModelFactory(
            factory: Factory,
            apiProviderOptions: ApiProviderOptions
        ): ViewModelProvider.Factory {
            return object : ViewModelProvider.Factory {
                override fun <T : ViewModel> create(modelClass: Class<T>): T {
                    return factory.create(apiProviderOptions) as T
                }
            }
        }
    }

    private val _citiesList = MutableLiveData<CityWeatherData?>()
    val citiesList: MutableLiveData<CityWeatherData?> = _citiesList

    fun getCitiesList(cityName: String, limit: Int) {
        viewModelScope.launch {
            val cityData = citiesListUseCase.getCitiesList(cityName, limit)
            _citiesList.value = cityData
        }
    }
    override fun onCleared() {
        super.onCleared()
        viewModelScope.coroutineContext.cancelChildren()
    }
}
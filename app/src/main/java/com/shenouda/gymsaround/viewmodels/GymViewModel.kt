package com.shenouda.gymsaround.viewmodels

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.shenouda.gymsaround.Gym
import com.shenouda.gymsaround.domain.repository.GymsRepository
import com.shenouda.gymsaround.gymList
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class GymViewModel @Inject constructor(
    private val gymsRepository: GymsRepository)
    : ViewModel() {
    private val _gyms =  MutableStateFlow<List<Gym>>(emptyList())
    val gyms:StateFlow<List<Gym>> =_gyms


init {
    loadGymList()
}
    private fun loadGymList() {
        viewModelScope.launch {
         _gyms.value = gymsRepository.getGym()
        }
    }
    fun toggleFavoriteState(gymId:Int){
        _gyms.value = _gyms.value.map {
            if (gymId==it.gymId) {
                it.copy(isFavourite = !it.isFavourite)
            }else{
                it
            }
        }
    }
}
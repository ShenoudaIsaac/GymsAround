package com.shenouda.gymsaround.viewmodels

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.shenouda.gymsaround.Gym
import com.shenouda.gymsaround.gymList

class GymViewModel: ViewModel() {
    var gymListState by  mutableStateOf(getGymList())

    private fun getGymList():List<Gym> {
        return gymList
    }
    fun toggleFavoriteState(gymId:Int){
        gymListState = gymListState.map {
            if (gymId==it.gymId) {
                it.copy(isFavourite = !it.isFavourite)

            }else{
                it
            }
        }
    }
}
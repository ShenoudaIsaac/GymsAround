package com.shenouda.gymsaround.viewmodels

import com.shenouda.gymsaround.Gym
import com.shenouda.gymsaround.gymList

class GymViewModel {
    fun getGymList():List<Gym> {
        return gymList
    }
}
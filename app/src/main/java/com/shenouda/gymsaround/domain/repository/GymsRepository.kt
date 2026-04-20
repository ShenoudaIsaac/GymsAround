package com.shenouda.gymsaround.domain.repository

import com.shenouda.gymsaround.Gym

interface GymsRepository {
    suspend fun getGym():List<Gym>
}
package com.shenouda.gymsaround.data.repository

import com.shenouda.gymsaround.Gym
import com.shenouda.gymsaround.data.remote.apis.GymsApiService
import com.shenouda.gymsaround.domain.repository.GymsRepository
import javax.inject.Inject

class GymsRepositoryImpl @Inject constructor(val gymsApiService: GymsApiService) : GymsRepository {
    private var cachedGyms: List<Gym>? = null
    override suspend fun getGym(): List<Gym> {
        return cachedGyms ?: gymsApiService.getGyms()
            .map { it.toDomain() }
            .also { cachedGyms = it }
    }
}
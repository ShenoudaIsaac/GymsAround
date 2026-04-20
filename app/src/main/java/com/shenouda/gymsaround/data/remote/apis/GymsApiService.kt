package com.shenouda.gymsaround.data.remote.apis

import com.shenouda.gymsaround.data.remote.dto.GymDto
import retrofit2.http.GET

interface GymsApiService {
    @GET("gyms.json")
    suspend fun getGyms():List<GymDto>
}
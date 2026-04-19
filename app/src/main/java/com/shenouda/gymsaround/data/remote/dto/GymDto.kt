package com.shenouda.gymsaround.data.remote.dto

import com.shenouda.gymsaround.Gym
import com.squareup.moshi.Json

data class GymDto(
    val id:Int,
    @Json(name = "gym_name") val gymName:String,
    @Json(name = "gym_location") val gymLocation:String,
    @Json(name = "is_open") val isOpen: Boolean
    ){
    fun toDomain():Gym=Gym(id,gymName,gymLocation,isOpen)
}



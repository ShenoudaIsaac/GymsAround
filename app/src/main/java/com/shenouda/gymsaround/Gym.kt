package com.shenouda.gymsaround

val gymList= listOf(
    Gym(1,"Empire","st:Albert elawal"),
    Gym(2,"Silver","st:Fawzy Moaaz"),
    Gym(3,"Empire","st:Albert elawal"),
    Gym(4,"Silver","st:Fawzy Moaaz"),
    Gym(5,"Empire","st:Albert elawal"),
    Gym(6,"Silver","st:Fawzy Moaaz"),
    Gym(7,"Empire","st:Albert elawal"),
    Gym(8,"Silver","st:Fawzy Moaaz"),
    Gym(9,"Empire","st:Albert elawal"),
    Gym(10,"Silver","st:Fawzy Moaaz"),
    Gym(11,"Empire","st:Albert elawal"),
    Gym(12,"Silver","st:Fawzy Moaaz"),
)
data class Gym(val gymId: Int, val name: String, val place: String, var isFavourite: Boolean = false)

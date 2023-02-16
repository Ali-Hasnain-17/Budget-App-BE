package com.pinchpenny.pinchpenny.dtos

data class UserCreateRequest(
    val firstName:String,
    val lastName:String,
    val phone:String,
    val type:String,
)

data class UserUpdateRequest(
    val id:Long,
    val title:String?,
    val mainId:Long?,
    val imageUrl:String?,
    val type:String?,
)

data class  UserDeleteRequest(
    val id:Long
)

data class UserResponse(
    val title:String,
    val mainId:Long,
    val imageUrl:String,
    val type:String,
)
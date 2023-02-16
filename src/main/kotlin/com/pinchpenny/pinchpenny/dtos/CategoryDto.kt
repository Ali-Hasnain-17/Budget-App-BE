package com.pinchpenny.pinchpenny.dtos

data class CategoryCreateRequest(
    val title:String,
    val mainId:Long?,
    val imageUrl:String,
    val type:String,
)

data class CategoryUpdateRequest(
    val id:Long,
    val title:String?,
    val mainId:Long?,
    val imageUrl:String?,
    val type:String?,
)

data class  CategoryDeleteRequest(
    val id:Long
)

data class CategoryResponse(
    val title:String,
    val mainId:Long,
    val imageUrl:String,
    val type:String,
)
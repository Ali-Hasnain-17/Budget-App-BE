package com.pinchpenny.pinchpenny.dtos

import com.pinchpenny.pinchpenny.main
import com.pinchpenny.pinchpenny.modals.Category
import com.pinchpenny.pinchpenny.modals.CategoryTypes
import java.util.UUID

data class CategoryCreateRequest(
    val title: String,
    val imageUrl: String,
    val type: CategoryTypes,
    val parentId: UUID?
)

fun CategoryCreateRequest.toEntity() = Category(
    imageUrl = imageUrl,
    title = title,
    type = type,
    parentId = parentId,
)

//data class CategoryUpdateRequest(
//    val id: UUID?,
//    val title: String?,
//    val mainId: UUID?,
//    val imageUrl:String?,
//    val type: String?,
//)
//
//fun CategoryUpdateRequest.toEntity() = Category(
//    id = id!!,
//    mainId = mainId!!,
//    imageUrl = imageUrl!!,
//    title = title!!,
//    type = type!!
//)
//
//data class  CategoryDeleteRequest(
//    val id:Long
//)

data class CategoryResponse(
    val title: String,
    val parentId: UUID?,
    val imageUrl: String,
    val type: CategoryTypes,
)

fun Category.toModel() = CategoryResponse(
    imageUrl = imageUrl,
    title = title,
    type = type,
    parentId = parentId
)

package com.pinchpenny.pinchpenny.dtos

import com.pinchpenny.pinchpenny.main
import com.pinchpenny.pinchpenny.modals.Category
import java.util.UUID

data class CategoryCreateRequest(
    val title: String,
    val mainId: UUID?,
    val imageUrl: String,
    val type: String
)

fun CategoryCreateRequest.toEntity() = Category(
    mainId = mainId!!,
    imageUrl = imageUrl,
    title = title,
    type = type
)

fun CategoryCreateRequest.toEntity() = Category(
    mainId = mainId!!,
    imageUrl = imageUrl,
    title = title,
    type = type
)
fun CategoryCreateRequest.toEntity() = Category(
    title = title,
    mainId = mainId!!,
    imageUrl = imageUrl,
    type = type
)
data class CategoryUpdateRequest(
    val id: UUID?,
    val title: String?,
    val mainId: UUID?,
    val imageUrl:String?,
    val type: String?,
)

fun CategoryUpdateRequest.toEntity() = Category(
    id = id!!,
    mainId = mainId!!,
    imageUrl = imageUrl!!,
    title = title!!,
    type = type!!
)

fun CategoryUpdateRequest.toEntity() = Category(
    id = id,
    title = title!!,
    mainId = mainId!!,
    imageUrl = imageUrl!!,
    type = type!!
)

data class  CategoryDeleteRequest(
    val id:Long
)

data class CategoryResponse(
    val title: String,
    val mainId: UUID,
    val imageUrl: String,
    val type: String,
)

fun CategoryResponse.toModel() = CategoryResponse(
    title = title,
    mainId = mainId,
    imageUrl = imageUrl,
    type = type
)
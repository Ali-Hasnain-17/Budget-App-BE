package com.pinchpenny.pinchpenny.services.base

import com.pinchpenny.pinchpenny.dtos.CategoryCreateRequest
import com.pinchpenny.pinchpenny.dtos.CategoryResponse
import java.util.UUID

interface CategoryService {
    fun createCategory(request: CategoryCreateRequest): CategoryResponse
    fun deleteCategory(categoryId: UUID): String

}
package com.pinchpenny.pinchpenny.services

import com.pinchpenny.pinchpenny.dtos.*
import com.pinchpenny.pinchpenny.exceptions.NotFoundException
import com.pinchpenny.pinchpenny.modals.Category
import com.pinchpenny.pinchpenny.repository.CategoryRepository
import com.pinchpenny.pinchpenny.services.base.CategoryService
import jakarta.transaction.Transactional
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import java.util.Optional
import java.util.UUID

@Service
@Transactional
class CategoryServiceImpl:CategoryService {
    @Autowired private lateinit var categoryRepository: CategoryRepository
    override fun createCategory(request: CategoryCreateRequest): CategoryResponse {
        return request
            .toEntity()
            .let { categoryRepository.save(it) }
            .toModel()
    }

    override fun deleteCategory(categoryId: UUID): String {
        // delete subcategories first before deleting main category
        val subCategories: List<Category> = categoryRepository.findSubCategories(categoryId)
        val parentCategory: Category = categoryRepository.findById(categoryId).get()
        subCategories.map { categoryRepository.delete(it) }
        categoryRepository.delete(parentCategory)
        return "Category deleted successfully"
    }
}




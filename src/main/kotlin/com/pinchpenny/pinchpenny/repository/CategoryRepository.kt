package com.pinchpenny.pinchpenny.repository

import com.pinchpenny.pinchpenny.modals.Category
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query
import java.util.*

interface CategoryRepository:JpaRepository<Category, Long> {
    fun findById(parentId: UUID): Optional<Category>

    @Query(
        "SELECT * FROM category c WHERE c.main_id = ?1",
        nativeQuery = true
    )
    fun findSubCategories(id: UUID): List<Category>

    fun deleteById(id: UUID): Category
}
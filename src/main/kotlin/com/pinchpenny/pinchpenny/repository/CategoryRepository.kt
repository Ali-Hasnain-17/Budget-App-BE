package com.pinchpenny.pinchpenny.repository

import com.pinchpenny.pinchpenny.modals.Category
import org.springframework.data.jpa.repository.JpaRepository
import java.util.Optional
import java.util.UUID

interface CategoryRepository:JpaRepository<Category, Long> {
    fun findByIdIn(categories:List<UUID>):Optional<List<Category>>
}
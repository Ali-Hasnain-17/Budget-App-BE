package com.pinchpenny.pinchpenny.repository

import com.pinchpenny.pinchpenny.modals.Category
import org.springframework.data.jpa.repository.JpaRepository

interface CategoryRepository:JpaRepository<Category, Long> {
}
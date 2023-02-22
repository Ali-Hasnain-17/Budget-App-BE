package com.pinchpenny.pinchpenny.controllers

import com.pinchpenny.pinchpenny.dtos.CategoryCreateRequest
import com.pinchpenny.pinchpenny.dtos.CategoryResponse
import com.pinchpenny.pinchpenny.dtos.Response
import com.pinchpenny.pinchpenny.repository.CategoryRepository
import com.pinchpenny.pinchpenny.services.base.CategoryService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import java.util.UUID

@RestController
@RequestMapping("/api/category")
class CategoryController {
    @Autowired private lateinit var categoryService: CategoryService
    @PostMapping("/create")
    fun createCategory(
        @RequestBody request: CategoryCreateRequest
    ): ResponseEntity<Response<CategoryResponse>> {
        return request
            .let { categoryService.createCategory(it) }
            .let { Response<CategoryResponse>(HttpStatus.CREATED, null, it) }
            .let { ResponseEntity.status(HttpStatus.CREATED).body(it) }
    }

    @DeleteMapping("/delete/{category_id}")
    fun deleteCategory(@PathVariable("category_id") categoryId: UUID): ResponseEntity<Response<String>> {
        val message: String = categoryService.deleteCategory(categoryId)
        return ResponseEntity.status(HttpStatus.OK).body(Response(HttpStatus.OK, null, message))
    }


}




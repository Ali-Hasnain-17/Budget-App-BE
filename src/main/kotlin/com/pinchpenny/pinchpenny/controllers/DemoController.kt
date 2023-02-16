package com.pinchpenny.pinchpenny.controllers

import org.springframework.security.access.prepost.PreAuthorize
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class DemoController {
    @GetMapping("/welcome")
    fun welcome(): String {
        return "Welcome"
    }
}
package com.pinchpenny.pinchpenny.controllers

import org.springframework.security.access.prepost.PreAuthorize
import org.springframework.security.core.context.SecurityContextHolder
import org.springframework.security.core.userdetails.UserDetails
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController
import kotlin.reflect.jvm.internal.impl.load.kotlin.JvmType

@RestController
class DemoController {
    @GetMapping("/welcome")
    fun welcome(): String {
        return "Welcome"
    }
}
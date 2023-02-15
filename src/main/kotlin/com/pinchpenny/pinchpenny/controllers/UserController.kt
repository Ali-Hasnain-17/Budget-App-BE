package com.pinchpenny.pinchpenny.controllers

import org.springframework.context.ApplicationEventPublisher
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/user")
class UserController {
    private var application:ApplicationEventPublisher
        get() {
            return application
        }
        set(value) {}
}
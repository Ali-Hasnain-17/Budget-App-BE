package com.pinchpenny.pinchpenny.repository

import com.pinchpenny.pinchpenny.modals.User
import org.springframework.data.jpa.repository.JpaRepository

interface UserRepository: JpaRepository<User, Long>
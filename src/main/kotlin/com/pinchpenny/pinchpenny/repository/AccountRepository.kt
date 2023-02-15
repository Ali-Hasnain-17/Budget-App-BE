package com.pinchpenny.pinchpenny.repository

import com.pinchpenny.pinchpenny.modals.Account
import org.springframework.data.jpa.repository.JpaRepository
import java.util.UUID

interface AccountRepository:JpaRepository<Account, UUID> {
}
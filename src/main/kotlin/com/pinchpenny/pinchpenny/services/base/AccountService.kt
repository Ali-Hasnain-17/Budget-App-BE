package com.pinchpenny.pinchpenny.services.base

import com.pinchpenny.pinchpenny.dtos.*
import com.pinchpenny.pinchpenny.modals.Account
import com.pinchpenny.pinchpenny.repository.AccountRepository
import com.pinchpenny.pinchpenny.repository.UserRepository
import jakarta.transaction.Transactional
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.autoconfigure.security.SecurityProperties.User
import org.springframework.http.ResponseEntity
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken
import org.springframework.security.core.Authentication
import org.springframework.security.core.context.SecurityContextHolder
import org.springframework.stereotype.Service
import java.util.*

interface AccountService {
    fun createAccount(request: AccountCreateRequest): AccountResponse;
    fun updateAccount(accountId: UUID, request: AccountUpdateRequest): AccountResponse;
    fun deleteAccount(accountId: UUID): String;
    fun getAllAccounts(userId: UUID): List<AccountResponse>
}
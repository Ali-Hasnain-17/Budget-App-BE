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

@Service
@Transactional
class AccountService {

    @Autowired private lateinit var accountRepository: AccountRepository
    @Autowired private lateinit var userRepository: UserRepository

    fun createAccount(request: AccountCreateRequest): AccountResponse {
        val user: com.pinchpenny.pinchpenny.modals.User = userRepository.findById(request.user_id).get()
        return request
            .toEntity(user)
            .let { accountRepository.save(it) }
            .toModel(user)
    }

    fun updateAccount(accountId: UUID, request: AccountUpdateRequest): AccountResponse {
        val account: Account = accountRepository.findById(accountId).get();
        val user: com.pinchpenny.pinchpenny.modals.User = userRepository.findById(request.user_id).get();
        account.balance = request.balance!!;
        account.type = request.type!!;
        return request
            .toEntity(user)
            .let { accountRepository.save(account) }
            .toModel(user)
    }

    fun deleteAccount(accountId: UUID): String {
        accountRepository.deleteById(accountId);
        return "Account Deleted Successfully";
    }

    fun getAllAccounts(userId: UUID): List<AccountResponse> {
        val account: List<Account> = accountRepository.findAll()
        val user: com.pinchpenny.pinchpenny.modals.User = userRepository.findById(userId).get()
        return account.map { it.toModel(user) }
    }

}
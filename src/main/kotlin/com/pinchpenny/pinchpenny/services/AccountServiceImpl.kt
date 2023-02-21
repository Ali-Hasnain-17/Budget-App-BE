package com.pinchpenny.pinchpenny.services

import com.pinchpenny.pinchpenny.dtos.*
import com.pinchpenny.pinchpenny.modals.Account
import com.pinchpenny.pinchpenny.modals.User
import com.pinchpenny.pinchpenny.repository.AccountRepository
import com.pinchpenny.pinchpenny.repository.UserRepository
import com.pinchpenny.pinchpenny.services.base.AccountService
import com.pinchpenny.pinchpenny.utils.UserUtils
import jakarta.transaction.Transactional
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.security.core.context.SecurityContextHolder
import org.springframework.security.core.userdetails.UserDetails
import org.springframework.stereotype.Service
import java.util.*

@Service
@Transactional
class AccountServiceImpl: AccountService {

    @Autowired private lateinit var accountRepository: AccountRepository
    @Autowired private lateinit var userUtils: UserUtils

    override fun createAccount(request: AccountCreateRequest): AccountResponse {
        val user: com.pinchpenny.pinchpenny.modals.User = userUtils.getCurrentLoggedInUser()
        return request
            .toEntity(user)
            .let { accountRepository.save(it) }
            .toModel(user)
    }

    override fun updateAccount(accountId: UUID, request: AccountUpdateRequest): AccountResponse {
        val account: Account = accountRepository.findById(accountId).get();
        val user: com.pinchpenny.pinchpenny.modals.User = userUtils.getCurrentLoggedInUser()
        account.balance = request.balance!!;
        account.type = request.type!!;
        return request
            .toEntity(user)
            .let { accountRepository.save(account) }
            .toModel(user)
    }

    override fun deleteAccount(accountId: UUID): String {
        accountRepository.deleteById(accountId);
        return "Account Deleted Successfully";
    }

    override fun getAllAccounts(userId: UUID): List<AccountResponse> {
        val account: List<Account> = accountRepository.findAll()
        val user: com.pinchpenny.pinchpenny.modals.User = userUtils.getCurrentLoggedInUser()
        return account.map { it.toModel(user) }
    }


}
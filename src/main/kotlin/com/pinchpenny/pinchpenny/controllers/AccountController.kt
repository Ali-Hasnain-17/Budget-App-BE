package com.pinchpenny.pinchpenny.controllers

import com.pinchpenny.pinchpenny.dtos.AccountCreateRequest
import com.pinchpenny.pinchpenny.dtos.AccountResponse
import com.pinchpenny.pinchpenny.dtos.AccountUpdateRequest
import com.pinchpenny.pinchpenny.dtos.Response
import com.pinchpenny.pinchpenny.modals.Account
import com.pinchpenny.pinchpenny.modals.User
import com.pinchpenny.pinchpenny.services.base.AccountService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import java.util.UUID

@RestController
@RequestMapping("/api/account")
class AccountController {
    @Autowired private lateinit var accountService: AccountService;

    @GetMapping("/list/{user_id}")
    fun getAllAccounts(@PathVariable("user_id") userId: UUID): ResponseEntity<Response<List<AccountResponse>>> {
        return accountService
                .getAllAccounts(userId)
                .let {
                Response<List<AccountResponse>>(HttpStatus.OK, null, it)
                }
                .let {
                    ResponseEntity.ok(it)
                }
    }

    @PostMapping("/create")
    fun createAccount(@RequestBody request: AccountCreateRequest): ResponseEntity<Response<AccountResponse>> {
        return request
            .let { accountService.createAccount(it) }
            .let { Response<AccountResponse>(HttpStatus.CREATED, null, it) }
            .let { ResponseEntity.status(HttpStatus.CREATED).body(it) }
    }

    @PostMapping("/update/{account_id}")
    fun updateAccount(@PathVariable("account_id") accountId: UUID, @RequestBody request: AccountUpdateRequest): ResponseEntity<Response<AccountResponse>> {
        return request
            .let { accountService.updateAccount(accountId, it) }
            .let { Response<AccountResponse>(HttpStatus.CREATED, null, it) }
            .let { ResponseEntity.status(HttpStatus.CREATED).body(it) }
    }

    @DeleteMapping("/delete/{account_id}")
    fun delete(@PathVariable("account_id") accountId: UUID): ResponseEntity<Response<String>> {
        val message: String =  accountService.deleteAccount(accountId)
        return ResponseEntity.ok(Response<String>(HttpStatus.OK, null, message))
    }
}
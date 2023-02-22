package com.pinchpenny.pinchpenny.controllers

import com.pinchpenny.pinchpenny.dtos.AccountResponse
import com.pinchpenny.pinchpenny.dtos.Response
import com.pinchpenny.pinchpenny.dtos.TransactionCreateRequest
import com.pinchpenny.pinchpenny.dtos.TransactionResponse
import com.pinchpenny.pinchpenny.services.base.TransactionService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.HttpStatusCode
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import java.util.*

@RestController
@RequestMapping("/api/transaction")

class TransactionController {
    @Autowired private lateinit var transactionService: TransactionService

    @GetMapping("account/{account_id}")
    fun getTransactionsAgainstAccount(@PathVariable("account_id") accountId:UUID) : Any{
        println("accountId = $accountId")
        transactionService.getTransactionsAgainstAccount(accountId)
        return 1

    }
    @GetMapping("user/{user_id}")
    fun getTransactionsAgainstUser(@PathVariable("user_id") userId:UUID) : Any{
        return transactionService
            .getTransactionAgainstUser(userId)
            .let{}
    }

    @PostMapping("/")
    fun createTransaction(@RequestBody request:TransactionCreateRequest):ResponseEntity<Response<TransactionResponse>> {
        return request
            .let { transactionService.createTransaction(it) }
            .let{ Response<TransactionResponse>(HttpStatus.CREATED, null, it)  }
            .let { ResponseEntity.status(HttpStatus.CREATED).body(it) }
    }
}
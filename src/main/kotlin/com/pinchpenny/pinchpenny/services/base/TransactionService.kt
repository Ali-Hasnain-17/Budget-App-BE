package com.pinchpenny.pinchpenny.services.base

import com.pinchpenny.pinchpenny.dtos.TransactionCreateRequest
import com.pinchpenny.pinchpenny.dtos.TransactionResponse
import com.pinchpenny.pinchpenny.modals.Transaction
import java.util.UUID
interface TransactionService {
    fun getTransactionsAgainstAccount(accountId:UUID): Any
    fun getTransactionAgainstUser(userId: UUID): List<TransactionResponse>
    fun createTransaction(transaction: TransactionCreateRequest): TransactionResponse
}
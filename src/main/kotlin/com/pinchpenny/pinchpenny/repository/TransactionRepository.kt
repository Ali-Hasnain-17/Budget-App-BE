package com.pinchpenny.pinchpenny.repository

import com.pinchpenny.pinchpenny.modals.Transaction
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query
import java.util.Optional
import java.util.UUID

interface TransactionRepository:JpaRepository<Transaction, Long> {
    fun findByAccount_Id(accountId:UUID):Optional<List<Transaction>>

    @Query("SELECT * FROM transaction t WHERE t.user_id=?1", nativeQuery = true)
    fun findByUserId(userId:UUID):Optional<List<Transaction>>
}
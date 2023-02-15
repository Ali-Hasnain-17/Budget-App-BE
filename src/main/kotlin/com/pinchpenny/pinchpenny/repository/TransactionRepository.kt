package com.pinchpenny.pinchpenny.repository

import com.pinchpenny.pinchpenny.modals.Transaction
import org.springframework.data.jpa.repository.JpaRepository

interface TransactionRepository:JpaRepository<Transaction, Long> {
}
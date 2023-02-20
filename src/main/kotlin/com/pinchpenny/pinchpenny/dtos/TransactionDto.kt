package com.pinchpenny.pinchpenny.dtos

import com.pinchpenny.pinchpenny.modals.Account
import com.pinchpenny.pinchpenny.modals.Category
import com.pinchpenny.pinchpenny.modals.Transaction
import com.pinchpenny.pinchpenny.modals.User
import java.util.*

data class TransactionCreateRequest(
    val date:Date,
    val amount:Double,
    val user_id:UUID
)

fun TransactionCreateRequest.toEntity(
    categories: List<Category>,
    user: User,
    account: Account
) = Transaction(
    date = date,
    amount = amount,
    user = user,
    account = account,
    categories = categories
)

data class TransactionUpdateRequest(
    val id: Long,
    val date: Date?,
    val amount: Double?,
    val user_id: UUID?
)

fun TransactionUpdateRequest.toEntity(
    categories: List<Category>,
    user: User,
    account: Account
) = Transaction(
    date = date!!,
    amount = amount!!,
    user = user,
    account = account,
    categories = categories
)

data class  TransactionDeleteRequest(
    val id: Long
)

data class TransactionResponse(
    val date: Date,
    val amount: Double,
    val user_id: UUID,
    val account_id: UUID,
    val accountType: String,
    val userName: String,
    val category: Map<UUID, Map<UUID, String>>
)

fun Transaction.toModel(user: User, category: Map<UUID, Map<UUID, String>>, account: Account) = TransactionResponse(
    date = date,
    amount = amount,
    user_id = user.id!!,
    account_id = account.id!!,
    accountType = account.type,
    userName = user.firstName + " " + user.lastName,
    category = category
)
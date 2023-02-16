package com.pinchpenny.pinchpenny.dtos

import java.util.*

data class TransactionCreateRequest(
    val date:Date,
    val amount:Double,
    val user_id:UUID
)

data class TransactionUpdateRequest(
    val id: Long,
    val date:Date?,
    val amount:Double?,
    val user_id:UUID?
)

data class  TransactionDeleteRequest(
    val id: Long
)

data class TransactionResponse(
    val date:Date,
    val amount:Double,
    val user_id:UUID
)
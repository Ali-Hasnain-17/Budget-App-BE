package com.pinchpenny.pinchpenny.dtos

import com.pinchpenny.pinchpenny.modals.Account
import java.util.UUID

data class AccountCreateRequest(
    val balance:Double,
    val type:String,
)

data class AccountUpdateRequest(
    val id:UUID,
    val balance:Double,
    val type:String,
    val user_id:UUID,
)
data class  AccountDeleteRequest(
    val id:UUID
)

data class AccountResponse(
    val balance:Double,
    val type:String
){
fun Account.toResponse() = AccountResponse(
    balance,
    type
)
}
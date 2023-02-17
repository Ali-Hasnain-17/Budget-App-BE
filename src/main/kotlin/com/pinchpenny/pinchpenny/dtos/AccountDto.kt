package com.pinchpenny.pinchpenny.dtos

import com.pinchpenny.pinchpenny.modals.Account
import com.pinchpenny.pinchpenny.modals.User
import java.util.UUID

data class AccountCreateRequest(
    val balance:Double,
    val type:String,
    val user_id: UUID
)
fun AccountCreateRequest.toEntity(user:User) = Account(
    balance = balance,
    type = type,
    user = user
)
data class AccountUpdateRequest(
    val id:UUID,
    val balance:Double,
    val type:String,
    val user_id:UUID,
)
fun AccountUpdateRequest.toEntity(user:User) = Account(
    balance = balance,
    type = type,
    user = user
)
data class  AccountDeleteRequest(
    val id:UUID
)

data class AccountResponse(
    val balance:Double,
    val type:String,
    val user_id: UUID?,
    val userEmail:String,
    val userName:String,

){
fun Account.toModel(user:User) = AccountResponse(
    user_id = user.id,
    balance = balance,
    type = type,
    userEmail = user.email,
    userName = user.firstName + " " + user.lastName
)
}
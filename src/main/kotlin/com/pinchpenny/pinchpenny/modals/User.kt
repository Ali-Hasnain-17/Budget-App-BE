package com.pinchpenny.pinchpenny.modals

import jakarta.persistence.*
import lombok.Builder
import java.util.UUID

@Entity
@Builder
@Table(name = "user_details")
data class User (
    @Id private val id: UUID,
    @OneToMany
    @JoinColumn(name="address_id", referencedColumnName = "Id")
    private val account:List<Account> = mutableListOf(),
    @OneToMany(mappedBy = "user")
    private val transactions: List<Transaction> = mutableListOf()
) {

}
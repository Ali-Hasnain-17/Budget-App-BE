package com.pinchpenny.pinchpenny.modals

import jakarta.persistence.*
import lombok.Builder
import java.util.UUID

@Entity
@Builder
@Table(name = "user_details")
data class User (
    @Id @GeneratedValue(strategy = GenerationType.AUTO) val id: UUID? = null,
    val firstName: String,
    val lastName: String,
    val email: String,
    val password: String,
    val role: String,
    @OneToMany
    @JoinColumn(name="address_id", referencedColumnName = "Id")
    val account:List<Account> = mutableListOf(),
    @OneToMany(mappedBy = "user")
    private val transactions: List<Transaction> = mutableListOf()
) {

}
package com.pinchpenny.pinchpenny.modals

import jakarta.persistence.*
import lombok.Builder
import java.util.UUID

@Entity
@Builder
@Table(name = "user_details")
data class User (
    @Id private val id: UUID,
    @Column(name="first_name")
    private var firstName:String,
    @Column(name="last_name")
    private var lastName:String,
    private var phone:String,
    @OneToMany(mappedBy = "user")
    private val account:List<Account> = mutableListOf(),
    @OneToMany(mappedBy = "user")
    private val transactions: List<Transaction> = mutableListOf()
) {

}
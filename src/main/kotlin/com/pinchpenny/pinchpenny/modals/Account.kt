package com.pinchpenny.pinchpenny.modals

import jakarta.persistence.*
import lombok.Builder
import lombok.Data
import java.util.*

@Entity
@Data
@Builder
data class Account(
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private val id:UUID?=null,
    private var balance:Double,
    private var type:String,
    @OneToMany(mappedBy = "account")
    private val transactions:List<Transaction> = mutableListOf(),
    @ManyToOne(cascade = [CascadeType.ALL])
    @JoinColumn(name="user_id", referencedColumnName = "id")
    private val user: User
)

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
    @Column(name = "id")
    private val Id:UUID,
    private var balance:Long,
    private var type:String,
    @OneToMany
    @JoinColumn(name="transaction_id", referencedColumnName = "id")
    private val transactions:List<Transaction> = mutableListOf(),
)

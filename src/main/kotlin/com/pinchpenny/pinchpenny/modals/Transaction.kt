package com.pinchpenny.pinchpenny.modals

import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import jakarta.persistence.*
import lombok.Builder
import lombok.Data
import java.util.Date
import java.util.UUID

@Entity
@Data
@Builder
data class Transaction(
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private val id: UUID?,
    private var date: Date,
    private var amount: Long,
    @ManyToMany(cascade = [CascadeType.ALL], fetch = FetchType.LAZY)
    @JoinTable(name = "category_transaction_bridge",
        joinColumns = [JoinColumn(name = "transaction_id", referencedColumnName = "id")],
        inverseJoinColumns = [JoinColumn(name = "category_id", referencedColumnName = "id")])
    @JsonIgnoreProperties("transactions")
    private val categories: List<Category>,
    @ManyToOne
    @JoinColumn(name="user_id", referencedColumnName = "id")
    private val user: User
)

package com.pinchpenny.pinchpenny.modals

import jakarta.persistence.*
import java.util.UUID

@Entity
@Table(name = "")
data class User (
    @Id private val id: UUID
)
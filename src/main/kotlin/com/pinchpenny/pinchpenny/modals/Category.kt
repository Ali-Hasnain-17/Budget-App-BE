package com.pinchpenny.pinchpenny.modals

import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.ManyToMany
import lombok.Builder
import lombok.Data
import java.util.UUID


@Entity
@Data
@Builder
data class Category(
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    val id: UUID? = null,
    @Column(name = "main_id")
    var mainId: UUID,
    @Column(name = "image_url")
    var imageUrl: String,
    var type: String,
    var title: String,
    @ManyToMany(mappedBy = "categories")
    @JsonIgnoreProperties("categories")
    var transactions: List<Transaction> = mutableListOf()
)

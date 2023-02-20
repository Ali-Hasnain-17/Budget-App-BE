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
data class Category (
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private val id: UUID? = null,
    @Column(name = "main_id")
    private var mainId: UUID,
    @Column(name="image_url")
    private var imageUrl: String,
    private var type: String,
    private var title: String,
    @ManyToMany(mappedBy = "categories")
    @JsonIgnoreProperties("categories")
    private var transactions:List<Transaction> = mutableListOf()

)

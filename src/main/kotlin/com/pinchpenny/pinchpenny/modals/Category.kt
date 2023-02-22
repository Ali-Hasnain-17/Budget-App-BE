package com.pinchpenny.pinchpenny.modals

import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import jakarta.persistence.*
import lombok.Builder
import lombok.Data
import java.util.UUID


@Entity
@Data
@Builder
data class Category (
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    var id: UUID? = null,
    @Column(name =" image_url") var imageUrl: String,
    @Enumerated(EnumType.STRING) var type: CategoryTypes,
    var title: String,
    @Column(name = "main_id") var parentId: UUID? = null,
    @ManyToMany(mappedBy = "categories")
    @JsonIgnoreProperties("categories")
    private var transactions:List<Transaction> = mutableListOf(),
)


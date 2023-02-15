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


@Entity
@Data
@Builder
data class Category (
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private val id:Long,
    @Column(name = "main_id")
    private var mainId:Long,
    @Column(name="image_url")
    private var imageUrl:String,
    private var type:String,
    @ManyToMany(mappedBy = "categories")
    @JsonIgnoreProperties("categories")
    private var transactions:List<Transaction> = mutableListOf()

)
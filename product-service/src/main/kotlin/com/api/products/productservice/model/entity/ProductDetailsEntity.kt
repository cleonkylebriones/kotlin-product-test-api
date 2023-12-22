package com.api.products.productservice.model.entity

import jakarta.persistence.*

@Entity
@Table(name = "details")
data class ProductDetailsEntity(
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    val details_id : Int? = null,
    val name : String? = null,
    val price : Int? = null,
//    @ManyToOne(fetch = FetchType.LAZY, targetEntity = ProductEntity::class)
//    @JoinColumn(name = "product_id", referencedColumnName = "id")
//    val product : ProductEntity? = null
)

package com.api.products.productservice.model.entity

import jakarta.persistence.*

@Entity
@Table(name = "products")
data class ProductEntity(
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    val id: Int? = null,
    val name: String? = null,
    var pricerange: String? = null,

    @OneToMany(
//        mappedBy = "product",
        cascade = [CascadeType.ALL],
        orphanRemoval = true,
        targetEntity = ProductDetailsEntity::class
    )
    @JoinColumn(name = "product_id", referencedColumnName = "id")
    var options: List<ProductDetailsEntity>? = mutableListOf()
)
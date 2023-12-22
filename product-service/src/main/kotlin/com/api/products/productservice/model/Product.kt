package com.api.products.productservice.model

import com.api.products.productservice.model.entity.ProductDetailsEntity
import jakarta.persistence.CascadeType
import jakarta.persistence.OneToMany

data class Product(
    val id: Int?,
    val name: String,
    val pricerange: String?,
    var options: List<ProductDetailsEntity>? = mutableListOf()
)

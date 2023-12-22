package com.api.products.productservice.repository

import com.api.products.productservice.model.entity.ProductEntity
import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.CrudRepository

interface ProductsRepository : CrudRepository<ProductEntity, Int> {
    fun findByNameContainingIgnoreCase(name: String) : List<ProductEntity>
}
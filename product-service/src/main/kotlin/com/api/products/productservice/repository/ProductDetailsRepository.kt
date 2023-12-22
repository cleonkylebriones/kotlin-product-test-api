package com.api.products.productservice.repository

import com.api.products.productservice.model.ProductDetailsDTO
import com.api.products.productservice.model.entity.ProductDetailsEntity
import org.springframework.data.repository.CrudRepository

interface ProductDetailsRepository : CrudRepository<ProductDetailsEntity, Int> {
}
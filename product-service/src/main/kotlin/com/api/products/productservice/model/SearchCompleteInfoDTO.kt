package com.api.products.productservice.model

import com.api.products.productservice.model.entity.ProductEntity

data class SearchCompleteInfoDTO(
    val meta : MetaDTO? = null,
    val items : List<ProductEntity>? = mutableListOf()
)

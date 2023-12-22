package com.api.products.productservice.model

data class SearchDTO(
    val searchTerm : String,
    val itemIds : ArrayList<Int>
)

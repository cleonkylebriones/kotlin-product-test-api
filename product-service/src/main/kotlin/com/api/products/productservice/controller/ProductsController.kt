package com.api.products.productservice.controller

import com.api.products.productservice.model.SearchCompleteInfoDTO
import com.api.products.productservice.model.SearchDTO
import com.api.products.productservice.model.entity.ProductEntity
import com.api.products.productservice.service.ProductsService
import org.springframework.web.bind.annotation.*
import java.util.*

@RestController
class ProductsController(val productsService: ProductsService) {
    @GetMapping("searchapi")
    fun performProductSearch(@RequestParam(required = false) searchTerm : String) : SearchDTO {
        return productsService.searchProductByTerm(searchTerm)
    }

    @GetMapping("product/{id}")
    fun getProductById(@PathVariable("id") id : Int): Optional<ProductEntity> {
        return productsService.retrieveProductById(id)
    }

    @GetMapping("combinedsearch")
    fun searchProductByTermCompleteInfo(@RequestParam(required = false) searchTerm : String): SearchCompleteInfoDTO {
        return productsService.searchProductByTermCompleteInfo(searchTerm)
    }

    @PostMapping("product")
    fun createProduct(@RequestBody product: ProductEntity): ProductEntity {
        return productsService.saveProduct(product)
    }
}
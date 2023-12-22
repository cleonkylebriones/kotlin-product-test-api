package com.api.products.productservice.service

import com.api.products.productservice.model.MetaDTO
import com.api.products.productservice.model.Product
import com.api.products.productservice.model.SearchCompleteInfoDTO
import com.api.products.productservice.model.SearchDTO
import com.api.products.productservice.model.entity.ProductDetailsEntity
import com.api.products.productservice.model.entity.ProductEntity
import com.api.products.productservice.repository.ProductDetailsRepository
import com.api.products.productservice.repository.ProductsRepository
import org.springframework.stereotype.Service
import java.util.*
import kotlin.collections.ArrayList

@Service
class ProductsService(
    val productsRepository: ProductsRepository,
    val productDetailsRepository: ProductDetailsRepository
) {
    fun searchProductByTerm(searchTerm : String) : SearchDTO {
        val result = productsRepository.findByNameContainingIgnoreCase(searchTerm)
        val itemIds : ArrayList<Int> = arrayListOf()

        result.forEach { product -> product.id?.let { itemIds.add(it) } }

        return SearchDTO(searchTerm, itemIds)
    }

    fun searchProductByTermCompleteInfo(searchTerm : String) : SearchCompleteInfoDTO {
        val result = productsRepository.findByNameContainingIgnoreCase(searchTerm)

        return SearchCompleteInfoDTO(MetaDTO(searchTerm, result.size), result)
    }

    fun retrieveProductById(id : Int) : Optional<ProductEntity> {
        return productsRepository.findById(id)
    }

    fun saveProduct(product : ProductEntity): ProductEntity {
        val items : MutableList<ProductDetailsEntity> = mutableListOf()
        var lowest: Int = 0
        var highest : Int = 0
        var priceRange : String = ""

        if(product.options?.isNotEmpty()!!) {

            product.options!!.iterator().forEach { detail ->
                run {
                    if(highest == 0 && lowest == 0) {
                        lowest = detail.price!!
                        highest = detail.price
                    } else if (detail.price!! > highest) {
                        highest = detail.price
                    } else if(detail.price < lowest ) {
                        lowest = detail.price
                    }

                    items.add(ProductDetailsEntity(detail.details_id, detail.name, detail.price))
                }
            }

            priceRange = "/$$lowest-/$$highest"
        }

        product.pricerange = priceRange
        return productsRepository.save(product)
    }
}
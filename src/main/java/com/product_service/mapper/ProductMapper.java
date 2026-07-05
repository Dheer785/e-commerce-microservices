package com.product_service.mapper;

import com.product_service.dto.ProductDto;
import com.product_service.entity.Product;
import org.jspecify.annotations.NonNull;

public class ProductMapper {

    public static ProductDto toDto(Product product) {

        ProductDto dto = new ProductDto();

        dto.setProductId(product.getProductId());
        dto.setProductName(product.getProductName());
        dto.setDescription(product.getDescription());
        dto.setPrice(product.getPrice());
        dto.setQuantity(product.getQuantity());
        if (product.getCategory() != null) {
            dto.setCategoryName(product.getCategory().getName());
        }

        if (product.getSubCategory() != null) {
            dto.setSubCategoryName(product.getSubCategory().getName());
            if (product.getBrand() != null) {
                dto.setBrandName(product.getBrand().getName());
            }
        }
        return dto;
    }

    public static Product toEntity(ProductDto dto) {

        Product product = new Product();

        product.setProductId(dto.getProductId());
        product.setProductName(dto.getProductName());
        product.setDescription(dto.getDescription());
        product.setPrice(dto.getPrice());
        product.setQuantity(dto.getQuantity());
        return product;
    }
}


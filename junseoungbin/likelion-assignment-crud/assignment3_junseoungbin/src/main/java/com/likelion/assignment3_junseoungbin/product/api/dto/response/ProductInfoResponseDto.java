package com.likelion.assignment3_junseoungbin.product.api.dto.response;

import com.likelion.assignment3_junseoungbin.product.domain.Product;

public record ProductInfoResponseDto(
        Long id,
        String name,
        int price,
        String category
) {
    public static ProductInfoResponseDto from(Product product) {
        return new ProductInfoResponseDto(
                product.getId(),
                product.getName(),
                product.getPrice(),
                product.getCategory()
        );
    }
}

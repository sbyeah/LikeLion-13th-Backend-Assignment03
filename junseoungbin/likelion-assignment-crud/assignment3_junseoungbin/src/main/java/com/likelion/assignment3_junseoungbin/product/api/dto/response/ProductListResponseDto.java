package com.likelion.assignment3_junseoungbin.product.api.dto.response;

import java.util.List;

public record ProductListResponseDto(
        List<ProductInfoResponseDto> productList
) {
    public static ProductListResponseDto from(List<ProductInfoResponseDto> list) {
        return new ProductListResponseDto(list);
    }
}

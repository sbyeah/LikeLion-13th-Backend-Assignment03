package com.likelion.assignment3_junseoungbin.product.api.dto.request;

public record ProductSaveRequestDto(
        String name,
        int price,
        String category
) {}

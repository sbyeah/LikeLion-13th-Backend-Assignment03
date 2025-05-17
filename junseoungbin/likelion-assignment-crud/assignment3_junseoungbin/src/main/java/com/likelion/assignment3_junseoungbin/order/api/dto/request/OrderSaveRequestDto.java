package com.likelion.assignment3_junseoungbin.order.api.dto.request;

public record OrderSaveRequestDto(
        Long productId,
        String customerName,
        int quantity,
        String orderDate
) {}

package com.likelion.assignment3_junseoungbin.order.api.dto.response;

import com.likelion.assignment3_junseoungbin.order.domain.Order;

public record OrderInfoResponseDto(
        Long id,
        String customerName,
        int quantity,
        String orderDate,
        Long productId
) {
    public static OrderInfoResponseDto from(Order order) {
        return new OrderInfoResponseDto(
                order.getId(),
                order.getCustomerName(),
                order.getQuantity(),
                order.getOrderDate(),
                order.getProduct().getId()
        );
    }
}

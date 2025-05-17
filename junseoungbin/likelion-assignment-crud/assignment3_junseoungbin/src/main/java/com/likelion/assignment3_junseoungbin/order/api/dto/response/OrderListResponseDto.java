package com.likelion.assignment3_junseoungbin.order.api.dto.response;

import java.util.List;

public record OrderListResponseDto(
        List<OrderInfoResponseDto> orderList
) {
    public static OrderListResponseDto from(List<OrderInfoResponseDto> list) {
        return new OrderListResponseDto(list);
    }
}

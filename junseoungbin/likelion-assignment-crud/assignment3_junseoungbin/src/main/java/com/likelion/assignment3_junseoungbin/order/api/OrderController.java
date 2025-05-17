package com.likelion.assignment3_junseoungbin.order.api;

import com.likelion.assignment3_junseoungbin.order.api.dto.request.OrderSaveRequestDto;
import com.likelion.assignment3_junseoungbin.order.api.dto.response.OrderListResponseDto;
import com.likelion.assignment3_junseoungbin.order.application.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/order")
public class OrderController {
    private final OrderService orderService;

    @PostMapping("/save")
    public ResponseEntity<String> orderSave(@RequestBody OrderSaveRequestDto dto) {
        orderService.orderSave(dto);
        return new ResponseEntity<>("주문 저장!", HttpStatus.CREATED);
    }

    @GetMapping("/{productId}")
    public ResponseEntity<OrderListResponseDto> orderFindByProduct(@PathVariable Long productId) {
        return ResponseEntity.ok(orderService.orderFindByProduct(productId));
    }
}

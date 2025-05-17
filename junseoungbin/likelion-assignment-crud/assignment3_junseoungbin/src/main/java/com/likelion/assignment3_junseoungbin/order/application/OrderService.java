package com.likelion.assignment3_junseoungbin.order.application;

import com.likelion.assignment3_junseoungbin.order.api.dto.request.OrderSaveRequestDto;
import com.likelion.assignment3_junseoungbin.order.api.dto.response.OrderInfoResponseDto;
import com.likelion.assignment3_junseoungbin.order.api.dto.response.OrderListResponseDto;
import com.likelion.assignment3_junseoungbin.order.domain.Order;
import com.likelion.assignment3_junseoungbin.order.domain.repository.OrderRepository;
import com.likelion.assignment3_junseoungbin.product.domain.Product;
import com.likelion.assignment3_junseoungbin.product.domain.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class OrderService {
    private final OrderRepository orderRepository;
    private final ProductRepository productRepository;

    @Transactional
    public void orderSave(OrderSaveRequestDto dto) {
        Product product = productRepository.findById(dto.productId())
                .orElseThrow(IllegalArgumentException::new);

        Order order = Order.builder()
                .product(product)
                .customerName(dto.customerName())
                .quantity(dto.quantity())
                .orderDate(dto.orderDate())
                .build();

        orderRepository.save(order);
    }

    public OrderListResponseDto orderFindByProduct(Long productId) {
        Product product = productRepository.findById(productId)
                .orElseThrow(IllegalArgumentException::new);

        List<Order> orders = orderRepository.findByProduct(product);
        List<OrderInfoResponseDto> orderDtos = orders.stream()
                .map(OrderInfoResponseDto::from)
                .toList();

        return OrderListResponseDto.from(orderDtos);
    }
}

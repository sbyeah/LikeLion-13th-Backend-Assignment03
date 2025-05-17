package com.likelion.assignment3_junseoungbin.order.domain.repository;

import com.likelion.assignment3_junseoungbin.order.domain.Order;
import com.likelion.assignment3_junseoungbin.product.domain.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface OrderRepository extends JpaRepository<Order, Long> {
    List<Order> findByProduct(Product product);
}

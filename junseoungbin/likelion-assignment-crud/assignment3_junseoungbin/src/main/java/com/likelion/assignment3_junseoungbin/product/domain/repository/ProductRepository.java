package com.likelion.assignment3_junseoungbin.product.domain.repository;

import com.likelion.assignment3_junseoungbin.product.domain.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {
}

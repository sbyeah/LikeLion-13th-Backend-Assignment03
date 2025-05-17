package com.likelion.assignment3_junseoungbin.product.application;

import com.likelion.assignment3_junseoungbin.product.api.dto.request.ProductSaveRequestDto;
import com.likelion.assignment3_junseoungbin.product.api.dto.response.ProductInfoResponseDto;
import com.likelion.assignment3_junseoungbin.product.api.dto.response.ProductListResponseDto;
import com.likelion.assignment3_junseoungbin.product.domain.Product;
import com.likelion.assignment3_junseoungbin.product.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class ProductService {
    private final ProductRepository productRepository;

    @Transactional
    public void productSave(ProductSaveRequestDto dto) {
        Product product = Product.builder()
                .name(dto.name())
                .price(dto.price())
                .category(dto.category())
                .build();
        productRepository.save(product);
    }

    public ProductListResponseDto productFindAll() {
        List<Product> products = productRepository.findAll();
        List<ProductInfoResponseDto> productDtoList = products.stream()
                .map(ProductInfoResponseDto::from)
                .toList();
        return ProductListResponseDto.from(productDtoList);
    }

    public ProductInfoResponseDto productFindOne(Long productId) {
        Product product = productRepository.findById(productId)
                .orElseThrow(IllegalArgumentException::new);
        return ProductInfoResponseDto.from(product);
    }
}

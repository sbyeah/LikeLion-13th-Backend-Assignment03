package com.likelion.assignment3_junseoungbin.product.api;

import com.likelion.assignment3_junseoungbin.product.api.dto.request.ProductSaveRequestDto;
import com.likelion.assignment3_junseoungbin.product.api.dto.response.ProductInfoResponseDto;
import com.likelion.assignment3_junseoungbin.product.api.dto.response.ProductListResponseDto;
import com.likelion.assignment3_junseoungbin.product.application.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/product")
public class ProductController {
    private final ProductService productService;

    @PostMapping("/save")
    public ResponseEntity<String> productSave(@RequestBody ProductSaveRequestDto dto) {
        productService.productSave(dto);
        return new ResponseEntity<>("상품 저장!", HttpStatus.CREATED);
    }

    @GetMapping("/all")
    public ResponseEntity<ProductListResponseDto> productFindAll() {
        return ResponseEntity.ok(productService.productFindAll());
    }

    @GetMapping("/{productId}")
    public ResponseEntity<ProductInfoResponseDto> productFindOne(@PathVariable Long productId) {
        return ResponseEntity.ok(productService.productFindOne(productId));
    }
}

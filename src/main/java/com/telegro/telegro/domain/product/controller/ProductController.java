package com.telegro.telegro.domain.product.controller;

import com.telegro.telegro.domain.product.dto.request.ProductRequestDTO;
import com.telegro.telegro.domain.product.dto.response.CreatedProductDTO;
import com.telegro.telegro.domain.product.dto.response.ProductDetailResponseDTO;
import com.telegro.telegro.domain.product.dto.response.ProductResponseDTO;
import com.telegro.telegro.domain.product.entity.enums.Category;
import com.telegro.telegro.domain.product.service.ProductService;
import com.telegro.telegro.global.apiPayLoad.exception.CustomException;
import com.telegro.telegro.global.apiPayLoad.exception.Error;
import com.telegro.telegro.global.apiPayLoad.response.SuccessResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping
@RequiredArgsConstructor
public class ProductController implements ProductControllerDocs{
    private final ProductService productService;

    @GetMapping("/products")
    public SuccessResponse<List<ProductResponseDTO>> getProducts(Long id, Category category, int page, int size) {
        return SuccessResponse.of(productService.getProducts(id, category, page, size));
    }

    @GetMapping("/products/{productId}")
    public SuccessResponse<ProductDetailResponseDTO> getProductDetail(Long id, @PathVariable Long productId) {
        return SuccessResponse.of(productService.getProductDetail(id, productId));
    }

    @PostMapping("/api/products")
    public SuccessResponse<CreatedProductDTO> createProduct(Long id, ProductRequestDTO request) {
        return SuccessResponse.of(productService.createProduct(id, request));
    }
}

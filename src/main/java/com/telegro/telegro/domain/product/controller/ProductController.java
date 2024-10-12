package com.telegro.telegro.domain.product.controller;

import com.telegro.telegro.domain.product.dto.request.ProductRequestDTO;
import com.telegro.telegro.domain.product.dto.response.CreatedProductDTO;
import com.telegro.telegro.domain.product.dto.response.ProductResponseDTO;
import com.telegro.telegro.domain.product.service.ProductService;
import com.telegro.telegro.global.apiPayLoad.response.SuccessResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping
@RequiredArgsConstructor
public class ProductController implements ProductControllerDocs{
    private final ProductService productService;

    @GetMapping("products/{productId}")
    public SuccessResponse<ProductResponseDTO> getProductDetail(@PathVariable Long productId) {
        return SuccessResponse.of(productService.getProduct(productId));
    }

    @PostMapping("/api/products")
    public SuccessResponse<CreatedProductDTO> createProduct(Long id, ProductRequestDTO request) {
        return SuccessResponse.of(productService.createProduct(id, request));
    }
}

package com.telegro.telegro.domain.product.controller;

import com.telegro.telegro.domain.product.dto.request.ProductRequestDTO;
import com.telegro.telegro.domain.product.dto.response.CreatedProductDTO;
import com.telegro.telegro.domain.product.dto.response.ProductResponseDTO;
import com.telegro.telegro.global.apiPayLoad.response.SuccessResponse;
import com.telegro.telegro.global.auth.annotation.LoginInfo;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

public interface ProductControllerDocs {
    @Operation(description = "상품을 상세 조회합니다.")
    @ApiResponse(responseCode = "200", description = "상품 조회 성공")
    public SuccessResponse<ProductResponseDTO> getProductDetail(@PathVariable Long productId);

    @Operation(description = "상품을 등록합니다.")
    @ApiResponse(responseCode = "200", description = "상품 등록 성공")
    public SuccessResponse<CreatedProductDTO> createProduct(@LoginInfo Long id, @RequestBody ProductRequestDTO request);
}

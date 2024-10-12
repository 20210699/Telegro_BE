package com.telegro.telegro.domain.product.dto.response;

import com.telegro.telegro.domain.product.entity.enums.Category;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Builder;

import java.util.List;

@Builder
public record ProductResponseDTO (
        @Schema(description = "모델명")
        String productModel,
        @Schema(description = "상품명")
        String productName,
        @Schema(description = "옵션")
        List<String> options,
        @Schema(description = "상품 카테고리")
        Category category,
        @Schema(description = "상품 내용")
        String content,
        @Schema(description = "가격 Bussiness")
        String priceBussiness,
        @Schema(description = "가격 Best")
        String priceBest,
        @Schema(description = "가격 Dealer")
        String priceDealer,
        @Schema(description = "가격 Customer")
        String priceCustomer,
        @Schema(description = "상품 사진들")
        List<String> pictures
){
}

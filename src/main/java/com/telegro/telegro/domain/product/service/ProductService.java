package com.telegro.telegro.domain.product.service;

import com.telegro.telegro.domain.product.dto.request.ProductRequestDTO;
import com.telegro.telegro.domain.product.dto.response.CreatedProductDTO;
import com.telegro.telegro.domain.product.dto.response.ProductResponseDTO;
import com.telegro.telegro.domain.product.entity.Product;
import com.telegro.telegro.domain.product.repository.ProductRepository;
import com.telegro.telegro.domain.user.entity.User;
import com.telegro.telegro.domain.user.repository.UserRepository;
import com.telegro.telegro.global.apiPayLoad.exception.CustomException;
import com.telegro.telegro.global.apiPayLoad.exception.Error;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Slf4j
@Service
@RequiredArgsConstructor
public class ProductService {
    private final UserRepository userRepository;
    private final ProductRepository productRepository;

    @Transactional
    public CreatedProductDTO createProduct(Long id, ProductRequestDTO request) {
        User user = userRepository.findById(id)
                .orElseThrow(() -> CustomException.of(Error.NOT_FOUND_ERROR));

        if(!user.getRole().toString().equals("ADMIN")) {
            throw CustomException.of(Error.FORBIDDEN_ACTION_ERROR);
        }

        Product product = Product.builder()
                .productModel(request.productModel())
                .productName(request.productName())
                .options(request.options())
                .category(request.category())
                .content(request.content())
                .priceBussiness(request.priceBussiness())
                .priceBest(request.priceBest())
                .priceDealer(request.priceDealer())
                .priceCustomer(request.priceCustomer())
                .pictures(request.pictures())
                .build();
        Product savedProduct = productRepository.save(product);


        return CreatedProductDTO.builder()
                .id(savedProduct.getId()).build();
    }

    public ProductResponseDTO getProduct(Long productId) {
        Product product = productRepository.findById(productId)
                .orElseThrow(() -> CustomException.of(Error.NOT_FOUND_ERROR));
        return ProductResponseDTO.builder()
                .productModel(product.getProductModel())
                .productName(product.getProductName())
                .options(product.getOptions())
                .category(product.getCategory())
                .priceBussiness(product.getPriceBussiness())
                .priceBest(product.getPriceBest())
                .priceDealer(product.getPriceDealer())
                .priceCustomer(product.getPriceCustomer())
                .pictures(product.getPictures())
                .content(product.getContent())
                .build();
    }
}

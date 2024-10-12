package com.telegro.telegro.domain.product.entity;

import com.telegro.telegro.domain.order.entity.Order;
import com.telegro.telegro.domain.product.entity.enums.Category;
import com.telegro.telegro.global.common.BaseEntity;
import com.telegro.telegro.global.converter.StringListConverter;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class Product extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String productName;

    @Column
    private String productModel;

    @Column(columnDefinition = "TEXT")
    @Convert(converter = StringListConverter.class)
    private List<String> options;

    @Enumerated(EnumType.STRING)
    @Column
    private Category category;

    @Column(columnDefinition = "TEXT")
    private String content;

    @Column
    private String priceBussiness;

    @Column
    private String priceBest;

    @Column
    private String priceDealer;

    @Column
    private String priceCustomer;

    @OneToMany(mappedBy = "product", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Order> orders;

    @Column(columnDefinition = "TEXT")
    @Convert(converter = StringListConverter.class)
    private List<String> pictures;
}

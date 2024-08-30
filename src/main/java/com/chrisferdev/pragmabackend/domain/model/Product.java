package com.chrisferdev.pragmabackend.domain.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Product {
    private Long id;
    private String name;
    private String description;
    private Integer quantity;
    private BigDecimal price;
    private List<Long> categoryIds;
    private List<Long> brandIds;
}

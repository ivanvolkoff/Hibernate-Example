package com.example.demo.model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Product {
    private Long id;
    private String productName;
    private String productBrand;
    private double price;
}

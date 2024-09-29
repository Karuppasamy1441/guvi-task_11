package com.example.demo.entity;

import jakarta.annotation.Generated;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "productDetails")
public class Product {
    @Id
    private Long productId;
    private String productName;
    private double productPrice;
    private String productCatogory;
}

package com.example.demo.service;

import com.example.demo.dto.ProductDto;

import java.util.List;

public interface ProductService {

    void addProductDetails(ProductDto productDto);

    List<ProductDto> getAllPrductsDetails();
}

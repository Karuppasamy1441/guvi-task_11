package com.example.demo.service.serviceImpl;

import com.example.demo.dto.ProductDto;
import com.example.demo.entity.Product;
import com.example.demo.repository.ProductRepository;
import com.example.demo.service.ProductService;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class ProductServiceImpl implements ProductService {

    private ModelMapper modelMapper;
    private ProductRepository productRepository;
    @Override
    public void addProductDetails(ProductDto productDto) {
        Product product=modelMapper.map(productDto,Product.class);
        productRepository.save(product);
    }

    @Override
    public List<ProductDto> getAllPrductsDetails() {
        List<Product> productList=productRepository.findAll();
        return productList.stream().map(product -> modelMapper.map(product,ProductDto.class)).collect(Collectors.toList());
    }
}

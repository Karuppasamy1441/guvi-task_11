package com.example.demo.controller;

import com.example.demo.dto.ProductDto;
import com.example.demo.entity.Product;
import com.example.demo.repository.ProductRepository;
import com.example.demo.service.ProductService;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@AllArgsConstructor
public class ProductController {

    private ProductService productService;
    private ModelMapper modelMapper;
//    private ProductRepository productRepository;
//    @GetMapping("getAllProductDetails")
//    List<ProductDto> getAllProductDetails(){
//        return productService.getAllPrductsDetails();
//    }
//
//    @PostMapping("addProductDetails")
//    String  addProductDetails(@RequestBody ProductDto productDto){
//        productService.addProductDetails(productDto);
//        return "product details added successfully";
//    }

//    @DeleteMapping("deleteAllDetails")
//    void deleteAllDetails(){
//        productRepository.deleteAll();
//    }

    @GetMapping("/homePage")
    public String getHomePage(){
        return "index";
    }

    @GetMapping("/addProductDetails")
    public String addProductDetails(Model model){
        ProductDto productDto=new ProductDto();
        model.addAttribute("product",modelMapper.map(productDto,Product.class));
        return "addNewProduct";
    }
    @PostMapping("/save")
    public String  saveProductDetails(@ModelAttribute("product") ProductDto productDto){
        productService.addProductDetails(productDto);
        return "redirect:/homePage";
    }
    @GetMapping("/getProductDetails")
    public String getProductDetails(Model model){
        model.addAttribute("getAllProductList",productService.getAllPrductsDetails());
        return "getProductDetails";
    }
    @GetMapping("/productList")
    public String productList(){
        return "redirect:/homePage";
    }

}

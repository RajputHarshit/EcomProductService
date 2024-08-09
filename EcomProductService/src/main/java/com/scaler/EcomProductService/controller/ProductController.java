package com.scaler.EcomProductService.controller;

import com.scaler.EcomProductService.dto.ProductListResponseDTO;
import com.scaler.EcomProductService.dto.ProductRequestDTO;
import com.scaler.EcomProductService.dto.ProductResponseDTO;
import com.scaler.EcomProductService.exception.ProductNotFoundException;
import com.scaler.EcomProductService.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.List;

@RestController
public class ProductController {


    private final ProductService productService;
    @Autowired
    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/products")
    public ResponseEntity getAllProducts(){
        /*ProductResponseDTO p1 = new ProductResponseDTO();
         p1.setId(1);
        p1.setPrice("150000");
        p1.setTitle("Iphone");
        p1.setCategory("Electronics");
        p1.setDescription("Kaafi Mehnga");
        p1.setImage("www.google.com/images/iphone");

        ProductResponseDTO p2 = new ProductResponseDTO();
        p2.setId(1);
        p2.setPrice("250000");
        p2.setTitle("MAC");
        p2.setCategory("Electronics");
        p2.setDescription("Kaafi Mehnga");
        p2.setImage("www.google.com/images/mac");

        List<ProductResponseDTO> products= Arrays.asList(p1,p2); */
        ProductListResponseDTO productListResponseDTO=productService.getAllProducts();

        return ResponseEntity.ok(productListResponseDTO);
    }
    @GetMapping("/products/{id}")
    public ResponseEntity getProductById(@PathVariable("id") int id) throws ProductNotFoundException {

        ProductResponseDTO productResponseDTO=productService.getProductById(id);
        return ResponseEntity.ok(productResponseDTO);
    }

    @PostMapping("/products")
    public ResponseEntity createProduct(@RequestBody ProductRequestDTO productRequestDTO){
        ProductResponseDTO responseDTO = productService.createProduct(productRequestDTO);
        return ResponseEntity.ok(responseDTO);
    }
}

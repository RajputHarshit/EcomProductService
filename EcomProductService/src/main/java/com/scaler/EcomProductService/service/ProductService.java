package com.scaler.EcomProductService.service;

import com.scaler.EcomProductService.dto.ProductListResponseDTO;
import com.scaler.EcomProductService.dto.ProductRequestDTO;
import com.scaler.EcomProductService.dto.ProductResponseDTO;
import com.scaler.EcomProductService.exception.ProductNotFoundException;
import org.springframework.stereotype.Service;

@Service
public interface ProductService {

    ProductResponseDTO getProductById(int id) throws ProductNotFoundException;
    ProductListResponseDTO getAllProducts();
    ProductResponseDTO createProduct(ProductRequestDTO productRequestDTO);
    boolean deleteProduct(int id);
}

package com.scaler.EcomProductService.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProductRequestDTO {

    private String title;
    private double price;
    private String description;
    private String image;
    private String category;
}

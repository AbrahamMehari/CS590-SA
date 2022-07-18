package com.ascs.RestClient.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProductDto {

    private int productNumber;
    private String name;
    private String description;
    private double price;
    private int supplierNumber;
    private List<ReviewDto> review = new ArrayList<>();
    private StockDto stock;

    public ProductDto(int productNumber, String name, String description, double price, int supplierNumber, StockDto stock) {
        this.productNumber = productNumber;
        this.name = name;
        this.description = description;
        this.price = price;
        this.supplierNumber = supplierNumber;
        this.stock = stock;
    }

    public void addReview(ReviewDto dto){
        review.add(dto);
    }
}

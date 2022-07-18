package com.ascs.Product.dto;

import com.ascs.Product.entity.Review;
import com.ascs.Product.entity.Stock;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

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
    private List<ReviewDto> review;
    private StockDto stock;

}

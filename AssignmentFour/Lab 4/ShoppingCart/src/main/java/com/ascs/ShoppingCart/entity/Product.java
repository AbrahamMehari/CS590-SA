package com.ascs.ShoppingCart.entity;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Product {

    private int productNumber;
    private String name;
    private double price;
}

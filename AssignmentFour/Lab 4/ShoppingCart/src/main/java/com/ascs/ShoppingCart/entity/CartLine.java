package com.ascs.ShoppingCart.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CartLine {

    private int quantity;
    private int productNumber;
    private Product product;
}

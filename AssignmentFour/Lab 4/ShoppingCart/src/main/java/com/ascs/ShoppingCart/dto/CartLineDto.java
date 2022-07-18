package com.ascs.ShoppingCart.dto;


import com.ascs.ShoppingCart.entity.Product;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class CartLineDto {

    private int quantity;
    private int productNumber;
    private ProductDto product;

}

package com.ascs.RestClient.domain.shoppingCart;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class CartLineDto {

    private int quantity;
    private int productNumber;
    private ProductShoppingCartDto product;

}

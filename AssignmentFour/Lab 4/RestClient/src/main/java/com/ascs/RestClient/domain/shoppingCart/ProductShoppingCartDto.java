package com.ascs.RestClient.domain.shoppingCart;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class ProductShoppingCartDto {

    private int productNumber;
    private String name;
    private double price;
}

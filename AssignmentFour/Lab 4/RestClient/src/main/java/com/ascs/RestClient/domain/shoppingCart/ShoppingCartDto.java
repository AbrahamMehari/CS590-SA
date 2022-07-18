package com.ascs.RestClient.domain.shoppingCart;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor

public class ShoppingCartDto {

    int ID;
    List<CartLineDto> cardLines = new ArrayList<>();

    public ShoppingCartDto(int ID) {
        this.ID = ID;
    }

    public void addCartLine(CartLineDto dto){
        cardLines.add(dto);
    }
}

package com.ascs.ShoppingCart.dto;

import com.ascs.ShoppingCart.entity.CartLine;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ShoppingCartDto {

    int ID;
    List<CartLineDto> cartLineDtoList;

    public ShoppingCartDto(int ID) {
        this.ID = ID;
    }

   public void addToCrtDto(CartLineDto cartLineDto){
        cartLineDtoList.add(cartLineDto);
   }
}

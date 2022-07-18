package com.ascs.ShoppingCart.entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Document
@NoArgsConstructor

@Data
public class ShoppingCart {

    @Id
    int ID;
    List<CartLine> cartLines;

    public ShoppingCart(int ID) {
        this.ID = ID;
    }

    public void addToCart(CartLine cartLine){
        cartLines.add(cartLine);
    }
    public void removeFromCart(CartLine cartLine){
        cartLines.remove(cartLines);
    }
    public void changeQuantity(CartLine cartLine, int quantity){
      cartLines.get(cartLine.getProductNumber()).setQuantity(quantity);
    }

    public void checkout(){
        System.out.println("========checkout============");
        for (CartLine line:
                cartLines) {
            System.out.println(line);
        }
    }
}

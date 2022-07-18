package com.ascs.RestClient.domain.shoppingCart;

import java.util.Collection;

public class ShoppingCarts {

    private Collection<ShoppingCartDto> cartDtos;

    public ShoppingCarts(Collection<ShoppingCartDto> cartDtos) {
        this.cartDtos = cartDtos;
    }

    public Collection<ShoppingCartDto> getCartDtos() {
        return cartDtos;
    }
}

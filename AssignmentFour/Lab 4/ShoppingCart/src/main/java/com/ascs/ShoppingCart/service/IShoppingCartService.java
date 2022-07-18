package com.ascs.ShoppingCart.service;

import com.ascs.ShoppingCart.entity.Product;
import com.ascs.ShoppingCart.entity.ShoppingCart;

import java.util.List;
import java.util.Optional;

public interface IShoppingCartService {

    ShoppingCart addShoppingCart(ShoppingCart shoppingCart);

    Optional<ShoppingCart> getShoppingCart(int id);

    List<ShoppingCart> getAllShoppingCart();
}

package com.ascs.ShoppingCart.repository;

import com.ascs.ShoppingCart.entity.ShoppingCart;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ShoppingCartRepository extends MongoRepository<ShoppingCart,Integer> {
    Optional<ShoppingCart> findShoppingCartByID(int id);
}

package com.ascs.Product.service;

import com.ascs.Product.entity.Product;

import java.util.List;
import java.util.Optional;

public interface IProductService {

    Product addProduct(Product product);

    Optional<Product> getProduct(int id);

    List<Product> getAllProduct();
}

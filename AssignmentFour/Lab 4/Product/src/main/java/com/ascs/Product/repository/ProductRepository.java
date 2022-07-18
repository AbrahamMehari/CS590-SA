package com.ascs.Product.repository;

import com.ascs.Product.entity.Product;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ProductRepository extends MongoRepository<Product,Integer> {
    Optional<Product> findProductByProductNumber(int productNumber);
}

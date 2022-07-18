package com.ascs.Product.service;

import com.ascs.Product.entity.Product;
import com.ascs.Product.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService implements IProductService{

    @Autowired
    private ProductRepository productRepository;

    @Override
    public Product addProduct(Product product) {
        return productRepository.save(product);
    }

    @Override
    public Optional<Product> getProduct(int id) {
        return productRepository.findProductByProductNumber(id);
    }

    @Override
    public List<Product> getAllProduct() {
        return productRepository.findAll();
    }
}

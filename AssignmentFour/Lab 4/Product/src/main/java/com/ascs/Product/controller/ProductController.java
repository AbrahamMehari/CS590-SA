package com.ascs.Product.controller;


import com.ascs.Product.dto.ProductDto;
import com.ascs.Product.dto.Products;
import com.ascs.Product.dto.ReviewDto;
import com.ascs.Product.dto.StockDto;
import com.ascs.Product.entity.Product;
import com.ascs.Product.entity.Review;
import com.ascs.Product.entity.Stock;
import com.ascs.Product.service.IProductService;
import com.ascs.Product.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Controller
@RequestMapping("/product")
public class ProductController {

    @Autowired
    private IProductService service;

    @PostMapping()
    public ResponseEntity<?> addProduct(@RequestBody ProductDto productDto) {
        Stock stock = new Stock(productDto.getStock().getNrInStack(),productDto.getStock().getLocationCode());
        List<Review> reviews = productDto.getReview().stream().map(n->new Review(n.getTitle(),n.getDescription(),
                n.getScore())).collect(Collectors.toList());

        Product product = new Product(productDto.getProductNumber(),productDto.getName(),productDto.getDescription(),
                productDto.getPrice(),productDto.getSupplierNumber(),reviews,stock);
        service.addProduct(product);
        return new ResponseEntity<>(productDto, HttpStatus.OK);
    }

    @GetMapping("/{productNumber}")
    public ResponseEntity<?> getProduct(@PathVariable int productNumber) {
        Optional<Product> product1 = service.getProduct(productNumber);
        if (product1.isPresent()) {
            Product product = product1.get();

            StockDto stock = new StockDto(product.getStock().getNrInStack(),product.getStock().getLocationCode());
            List<ReviewDto> reviews = product.getReview().stream().map(n->new ReviewDto(n.getTitle(),n.getDescription(),
                    n.getScore())).collect(Collectors.toList());

            ProductDto productDto = new ProductDto(product.getProductNumber(),product.getName(), product.getDescription(),
                    product.getPrice(),product.getSupplierNumber(),reviews,stock);
            return new ResponseEntity<>(productDto, HttpStatus.OK);
        }
        return new ResponseEntity<>("product couldn't find", HttpStatus.NO_CONTENT);
    }

    @GetMapping
    public ResponseEntity<?> getAll() {
        List<Product> list = service.getAllProduct();
        List<ProductDto> resultList = list.stream().map(m->{
            List<ReviewDto> reviewDtos = new ArrayList<>();
            for (Review r:
                 m.getReview()) {
                reviewDtos.add(new ReviewDto(r.getTitle(),r.getDescription(),r.getScore()));
            }
          StockDto stockDto = new StockDto(m.getStock().getNrInStack(),m.getStock().getLocationCode());

            return new ProductDto(m.getProductNumber(),m.getName(),
                    m.getDescription(),m.getPrice(),m.getSupplierNumber(),
                    reviewDtos,stockDto);

        }).collect(Collectors.toList());
        Products products = new Products(resultList);
        return new ResponseEntity<>(products, HttpStatus.OK);
    }


}

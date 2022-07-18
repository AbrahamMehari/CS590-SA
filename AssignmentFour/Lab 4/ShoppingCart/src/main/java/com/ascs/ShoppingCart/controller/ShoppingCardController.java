package com.ascs.ShoppingCart.controller;


import com.ascs.ShoppingCart.dto.CartLineDto;
import com.ascs.ShoppingCart.dto.ProductDto;
import com.ascs.ShoppingCart.dto.ShoppingCartDto;
import com.ascs.ShoppingCart.entity.CartLine;
import com.ascs.ShoppingCart.entity.Product;
import com.ascs.ShoppingCart.entity.ShoppingCart;
import com.ascs.ShoppingCart.service.IShoppingCartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Controller
@RequestMapping("/shoppingcart")
public class ShoppingCardController {

    @Autowired
    private IShoppingCartService service;

    @PostMapping()
    public ResponseEntity<?> addToShoppingCart(@RequestBody ShoppingCartDto shoppingCartDto) {

        ShoppingCart shoppingCart = new ShoppingCart(shoppingCartDto.getID());
        shoppingCart.getCartLines().forEach(m->{
            Product product = new Product(m.getProduct().getProductNumber(),
                    m.getProduct().getName(),m.getProduct().getPrice());

            CartLine line1 =  new CartLine(m.getQuantity(),m.getProductNumber(),product);
            shoppingCart.addToCart(line1);
        });
        System.out.println(shoppingCart);
        service.addShoppingCart(shoppingCart);
        return new ResponseEntity<>(shoppingCart, HttpStatus.OK);

    }

    @GetMapping("/{cartnumber}")
    public ResponseEntity<?> getShoppingCart(@PathVariable int cartnumber) {
        Optional<ShoppingCart> shoppingCart1 = service.getShoppingCart(cartnumber);

        if (shoppingCart1.isPresent()) {
            ShoppingCart cart = shoppingCart1.get();
            ShoppingCartDto dto = new ShoppingCartDto(cart.getID());
            cart.getCartLines().stream().forEach(m->{
                ProductDto product = new ProductDto(m.getProduct().getProductNumber(),
                        m.getProduct().getName(),m.getProduct().getPrice());

                CartLineDto line1 =  new CartLineDto(m.getQuantity(),m.getProductNumber(),product);
                dto.addToCrtDto(line1);
            });
            return new ResponseEntity<>(dto, HttpStatus.OK);
        }
        return new ResponseEntity<>("shopping cart couldn't find", HttpStatus.NO_CONTENT);
    }
    @GetMapping
    public ResponseEntity<?> getAll() {
        List<ShoppingCart> list = service.getAllShoppingCart();
        return new ResponseEntity<>(list, HttpStatus.OK);
    }


}

package com.ascs.Product.dto;

import java.util.Collection;

public class Products {

    private Collection<ProductDto> productDtos;

    public Products(Collection<ProductDto> productDtos) {
        this.productDtos = productDtos;
    }

    public Collection<ProductDto> getProductDtos() {
        return productDtos;
    }
}

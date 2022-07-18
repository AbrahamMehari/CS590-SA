package com.ascs.RestClient.domain;

import lombok.NoArgsConstructor;

import java.util.Collection;
@NoArgsConstructor
public class Products {

    private Collection<ProductDto> productDtos;



    public Products(Collection<ProductDto> productDtos) {
        this.productDtos = productDtos;
    }

    public Collection<ProductDto> getProductDtos() {
        return productDtos;
    }
}

package com.ascs.Product.entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class Stock {
    private int nrInStack;
    private int locationCode;
}

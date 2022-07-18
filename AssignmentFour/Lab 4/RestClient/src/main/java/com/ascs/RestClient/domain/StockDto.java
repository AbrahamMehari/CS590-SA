package com.ascs.RestClient.domain;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class StockDto {
    private int nrInStack;
    private int locationCode;
}

package edu.miu.bookapplication.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Book {
    private String author;
    private String title;
    private String iSBN;
    private double price;
}

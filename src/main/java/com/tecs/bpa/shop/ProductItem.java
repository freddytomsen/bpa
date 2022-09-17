package com.tecs.bpa.shop;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ProductItem {

    private String name;
    private double price;
    private double weight;
    private boolean dangerousGoods;
}

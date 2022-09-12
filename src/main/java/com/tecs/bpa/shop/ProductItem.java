package com.tecs.bpa.shop;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ProductItem {

    String name;
    double price;
    double weight;
    boolean dangerousGoods;
}

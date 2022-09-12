package com.tecs.bpa.shop;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class CartItem {

    private ProductItem productItem;
    private int amount;
}

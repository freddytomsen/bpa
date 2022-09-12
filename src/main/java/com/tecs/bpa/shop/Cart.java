package com.tecs.bpa.shop;

import lombok.Data;

import java.util.List;

@Data
public class Cart {

    private List<CartItem> cartItemList;

}

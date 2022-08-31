package com.tecs.bpa.ordering;

import lombok.Data;

import java.util.List;

@Data
public class Cart {

    private List<CartItem> cartItemList;

}

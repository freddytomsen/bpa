package com.tecs.bpa.ordering;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
public class CartItem {

    private String name;

    private Double price;

    private int amount;

}

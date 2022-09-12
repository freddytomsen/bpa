package com.tecs.bpa.shop;

import lombok.Data;

@Data
public class OrderItem {

    private CartItem product;

    private Double orderPrice;

}

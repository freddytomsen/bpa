package com.tecs.bpa.ordering;

import lombok.Data;

@Data
public class OrderItem {

    private CartItem product;

    private Double orderPrice;

}

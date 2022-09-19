package com.tecs.bpa.order;

import com.tecs.bpa.shop.CartItem;
import lombok.Data;

@Data
public class OrderItem {

    private CartItem product;

    private Double orderPrice;

}

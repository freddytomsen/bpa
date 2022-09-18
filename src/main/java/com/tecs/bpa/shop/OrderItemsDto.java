package com.tecs.bpa.shop;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class OrderItemsDto {

    private List<OrderItem> orderItemList;
    private double totalPrice;

}

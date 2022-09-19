package com.tecs.bpa.order;

import com.tecs.bpa.order.OrderItem;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class OrderItemsDto {

    private List<OrderItem> orderItemList;
    private double totalPrice;

}

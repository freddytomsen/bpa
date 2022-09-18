package com.tecs.bpa.shop;

import java.util.ArrayList;
import java.util.List;

public class OrderItemsCreator {

    public static final double AMOUNT_DISCOUNT = 0.95;

    public OrderItemsCreator() {
    }

    List<OrderItem> createOrderItems(Cart cart) {
        List<OrderItem> orderItemList = new ArrayList();
        cart.getCartItemList().stream().forEach(p -> {
            double orderPrice;
            if (p.getAmount() > 5) {
                orderPrice = p.getProductItem().getPrice() * p.getAmount() * AMOUNT_DISCOUNT;
            } else {
                orderPrice = p.getProductItem().getPrice() * p.getAmount();
            }
            OrderItem orderItem = new OrderItem();
            orderItem.setOrderPrice(orderPrice);
            orderItemList.add(orderItem);
        });
        return orderItemList;
    }
}
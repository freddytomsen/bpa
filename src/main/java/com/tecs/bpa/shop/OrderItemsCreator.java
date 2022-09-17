package com.tecs.bpa.shop;

import java.util.ArrayList;
import java.util.List;

public class OrderItemsCreator {
    public OrderItemsCreator() {
    }

    List<OrderItem> createOrderItems(Cart cart) {
        List<OrderItem> orderItemList = new ArrayList<OrderItem>();
        cart.getCartItemList().stream().forEach(p -> {
            double orderPrice;
            if (p.getAmount() > 5) {
                orderPrice = p.getProductItem().getPrice() * p.getAmount() * Checkout.AMOUNT_DISCOUNT;
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
package com.tecs.bpa.shop;

import java.util.ArrayList;
import java.util.List;

public class OrderItemsCreator {

    public static final double CUSTOMER_DISCOUNT = 0.9;
    public static final double AMOUNT_DISCOUNT = 0.95;

    public OrderItemsCreator() {
    }

    OrderItemsDto createOrderItems(Cart cart, CustomerLevel level) {
        List<OrderItem> orderItemList = new ArrayList();
        for (CartItem cartItem: cart.getCartItemList()) {
                double orderPrice;
                if (cartItem.getAmount() > 5) {
                    orderPrice = cartItem.getProductItem().getPrice() * cartItem.getAmount() * AMOUNT_DISCOUNT;
                } else {
                    orderPrice = cartItem.getProductItem().getPrice() * cartItem.getAmount();
                }
                OrderItem orderItem = new OrderItem();
                orderItem.setOrderPrice(orderPrice);
                orderItemList.add(orderItem);
        }
        double totalOrderItemPrice = orderItemList.stream().mapToDouble(o -> o.getOrderPrice()).sum();
        if (level == CustomerLevel.GOLD) {
            totalOrderItemPrice = totalOrderItemPrice * CUSTOMER_DISCOUNT;
        }
        OrderItemsDto result = new OrderItemsDto();
        result.setTotalPrice(totalOrderItemPrice);
        result.setOrderItemList(orderItemList);

        return result;
    }
}
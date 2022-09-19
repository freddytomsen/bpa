package com.tecs.bpa.order;

import com.tecs.bpa.customer.CustomerLevel;
import com.tecs.bpa.shop.Cart;
import com.tecs.bpa.shop.CartItem;

import java.util.ArrayList;
import java.util.List;

public class OrderItemsCreator {

    public static final double CUSTOMER_DISCOUNT_GOLD = 0.8;
    public static final double CUSTOMER_DISCOUNT_SILVER = 0.9;
    public static final double CUSTOMER_DISCOUNT_BRONZE = 0.5;
    public static final double AMOUNT_DISCOUNT = 0.95;

    public OrderItemsCreator() {
    }

    public OrderItemsDto createOrderItems(Cart cart, CustomerLevel level) {
        List<OrderItem> orderItemList = new ArrayList();
        for (CartItem cartItem: cart.getCartItemList()) {
                double orderPrice;
                if (cartItem.getAmount() > 5) {
                    orderPrice = cartItem.getProductItem().getPrice() * cartItem.getAmount() * AMOUNT_DISCOUNT;
                    if (level == CustomerLevel.BRONZE) {
                        orderPrice = orderPrice * CUSTOMER_DISCOUNT_BRONZE;
                    }
                    if (level == CustomerLevel.SILVER) {
                        orderPrice = orderPrice * CUSTOMER_DISCOUNT_SILVER;
                    }
                    if (level == CustomerLevel.GOLD) {
                        orderPrice = orderPrice * CUSTOMER_DISCOUNT_GOLD;
                    }
                } else {
                    orderPrice = cartItem.getProductItem().getPrice() * cartItem.getAmount();
                }
                OrderItem orderItem = new OrderItem();
                orderItem.setOrderPrice(orderPrice);
                orderItemList.add(orderItem);
        }
        double totalOrderItemPrice = orderItemList.stream().mapToDouble(o -> o.getOrderPrice()).sum();
        if (level == CustomerLevel.BRONZE) {
            totalOrderItemPrice = totalOrderItemPrice * CUSTOMER_DISCOUNT_BRONZE;
        }
        if (level == CustomerLevel.SILVER) {
            totalOrderItemPrice = totalOrderItemPrice * CUSTOMER_DISCOUNT_SILVER;
        }
        if (level == CustomerLevel.GOLD) {
            totalOrderItemPrice = totalOrderItemPrice * CUSTOMER_DISCOUNT_GOLD;
        }
        OrderItemsDto result = new OrderItemsDto();
        result.setTotalPrice(totalOrderItemPrice);
        result.setOrderItemList(orderItemList);

        return result;
    }
}
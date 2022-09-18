package com.tecs.bpa.shop;

import java.util.List;

public class TotalItemPriceCalculator {

    public static final double CUSTOMER_DISCOUNT = 0.9;

    public TotalItemPriceCalculator() {
    }

    double calculateTotalOrderItemPrice(Level level, List<OrderItem> orderItemList) {
        double totalOrderItemPrice = orderItemList.stream().mapToDouble(o -> o.getOrderPrice()).sum();

        if (level == Level.GOLD) {
            totalOrderItemPrice = totalOrderItemPrice * CUSTOMER_DISCOUNT;
        }
        return totalOrderItemPrice;
    }
}
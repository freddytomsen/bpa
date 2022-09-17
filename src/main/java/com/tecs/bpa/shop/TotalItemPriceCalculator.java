package com.tecs.bpa.shop;

import java.util.List;

public class TotalItemPriceCalculator {
    public TotalItemPriceCalculator() {
    }

    double calculateTotalOrderItemPrice(Level level, List<OrderItem> orderItemList) {
        double totalOrderItemPrice = orderItemList.stream().mapToDouble(o -> o.getOrderPrice()).sum();

        if (level == Level.GOLD) {
            totalOrderItemPrice = totalOrderItemPrice * Checkout.CUSTOMER_DISCOUNT;
        }
        return totalOrderItemPrice;
    }
}
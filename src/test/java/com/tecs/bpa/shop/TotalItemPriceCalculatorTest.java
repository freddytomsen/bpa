package com.tecs.bpa.shop;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class TotalItemPriceCalculatorTest {

    private TotalItemPriceCalculator calculator = new TotalItemPriceCalculator();

    @Test
    void testTotalPriceNormalLevel() {

        OrderItem item1 = new OrderItem();
        item1.setOrderPrice(9.90);
        OrderItem item2 = new OrderItem();
        item2.setOrderPrice(19.90);
        OrderItem item3 = new OrderItem();
        item3.setOrderPrice(7.80);
        List<OrderItem> orderItemList = List.of(item1, item2, item3);

        double totalOrderItemPrice = calculator.calculateTotalOrderItemPrice(Level.NORMAL, orderItemList);

        assertEquals(37.6, totalOrderItemPrice,0.1);

    }

    @Test
    void testTotalPriceGoldLevel() {

        OrderItem item1 = new OrderItem();
        item1.setOrderPrice(9.90);
        OrderItem item2 = new OrderItem();
        item2.setOrderPrice(19.90);
        OrderItem item3 = new OrderItem();
        item3.setOrderPrice(7.80);
        List<OrderItem> orderItemList = List.of(item1, item2, item3);

        double totalOrderItemPrice = calculator.calculateTotalOrderItemPrice(Level.GOLD, orderItemList);

        assertEquals(33.8, totalOrderItemPrice,0.1);

    }

}
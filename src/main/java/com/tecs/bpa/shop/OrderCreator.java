package com.tecs.bpa.shop;

import java.util.List;

public class OrderCreator {

    public OrderCreator() {
    }

    Order createOrder(
            Customer customer, ShipmentDetails shipmentDetails,
            List<OrderItem> orderItemList, double totalOrderItemPrice) {
        Order order = new Order();
        order.setOrderItemList(orderItemList);
        order.setCustomer(customer);
        order.setTotalPrice(totalOrderItemPrice);
        order.setShipmentDetails(shipmentDetails);
        return order;
    }
}
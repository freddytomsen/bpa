package com.tecs.bpa.shop;

import java.util.List;

public class OrderCreator {

    public OrderCreator() {
    }

    Order createOrder(
            Customer customer, ShipmentDetails shipmentDetails,
            OrderItemsDto orderItemsDto) {
        Order order = new Order();
        order.setOrderItemList(orderItemsDto.getOrderItemList());
        order.setCustomer(customer);
        order.setTotalPrice(orderItemsDto.getTotalPrice());
        order.setShipmentDetails(shipmentDetails);
        return order;
    }
}
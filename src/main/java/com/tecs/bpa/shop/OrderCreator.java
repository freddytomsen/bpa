package com.tecs.bpa.shop;

import java.util.List;

public class OrderCreator {
    public OrderCreator() {
    }

    Order createOrder(
            OrderInfo orderInfo, Customer customer, ShipmentDetails shipmentDetails,
            List<OrderItem> orderItemList, double totalOrderItemPrice) {
        Order order = new Order();
        order.setOrderItemList(orderItemList);
        order.setCustomer(customer);
        if (orderInfo.getRecipient() == null) {
            Recipient recipient = new Recipient(customer.getName(), customer.getWorldZone());
            shipmentDetails.setRecipient(recipient);
        } else {
            shipmentDetails.setRecipient(orderInfo.getRecipient());
        }
        order.setTotalPrice(totalOrderItemPrice);
        order.setShipmentDetails(shipmentDetails);
        return order;
    }
}
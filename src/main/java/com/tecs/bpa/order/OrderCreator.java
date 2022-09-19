package com.tecs.bpa.order;

import com.tecs.bpa.customer.Customer;
import com.tecs.bpa.shop.ShipmentDetails;

public class OrderCreator {

    public OrderCreator() {
    }

    public Order createOrder(
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
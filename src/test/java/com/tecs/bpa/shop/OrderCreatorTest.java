package com.tecs.bpa.shop;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class OrderCreatorTest {

    private OrderCreator orderCreator = new OrderCreator();

    @Test
    void testCreateOrder() {
        Customer customer = new Customer("Peter", Zone.NORTH_AMERICA, Level.NORMAL);
        ShipmentDetails shipmentDetails = new ShipmentDetails();
        List<OrderItem> orderItems = List.of(new OrderItem());

        Order order = orderCreator.createOrder(customer, shipmentDetails, orderItems, 123.4);

        assertEquals(customer, order.getCustomer());
        assertEquals(shipmentDetails, order.getShipmentDetails());
        assertEquals(orderItems, order.getOrderItemList());
    }

}
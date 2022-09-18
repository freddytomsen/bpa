package com.tecs.bpa.shop;

import com.tecs.bpa.customer.Customer;
import com.tecs.bpa.customer.CustomerLevel;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class OrderCreatorTest {

    private OrderCreator orderCreator = new OrderCreator();

    @Test
    void testCreateOrder() {
        Customer customer = new Customer("Peter", Zone.NORTH_AMERICA, CustomerLevel.NORMAL);
        ShipmentDetails shipmentDetails = new ShipmentDetails();
        List<OrderItem> orderItems = List.of(new OrderItem());
        OrderItemsDto orderItemsDto = new OrderItemsDto();
        orderItemsDto.setOrderItemList(orderItems);
        orderItemsDto.setTotalPrice(123.4);

        Order order = orderCreator.createOrder(customer, shipmentDetails, orderItemsDto);

        assertEquals(customer, order.getCustomer());
        assertEquals(shipmentDetails, order.getShipmentDetails());
        assertEquals(orderItems, order.getOrderItemList());
    }

}
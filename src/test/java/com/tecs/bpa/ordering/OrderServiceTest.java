package com.tecs.bpa.ordering;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class OrderServiceTest {



    @Test
    public void checkOutTest() {
        OrderService orderService = new OrderService();

        Cart cart = new Cart();
        List<CartItem> itemList =
                List.of(new CartItem("Usb wire", 9.99, 1),
                        new CartItem("Mouse XCB", 19.90, 1),
                        new CartItem("Vitamins D", 7.80, 6));
        cart.setCartItemList(itemList);

        ShipmentInfo info = new ShipmentInfo(
                new Customer("Peter", Zone.NORTH_AMERICA, Level.NORMAL),
                new Recipient("Peter", Zone.NORTH_AMERICA),
                true);
        Order order = orderService.checkout(cart, info);

        assertEquals(74.35, order.getTotalPrice());
        assertEquals(9.90, order.getShippingCosts());
        assertEquals(10.0, order.getOrderItemList().get(0).getOrderPrice());
        assertEquals(10.0, order.getOrderItemList().get(1).getOrderPrice());
        assertEquals(56.0, order.getOrderItemList().get(2).getOrderPrice());

    }

}
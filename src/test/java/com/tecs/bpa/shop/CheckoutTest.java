package com.tecs.bpa.shop;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class CheckoutTest {

    @Test
    public void checkoutTest_safeGoods_priorityStandard_zoneNorthAmerica_levelGold_quantityDiscount() {
        Checkout orderService = new Checkout();

        Cart cart = new Cart();
        List<CartItem> itemList =
                List.of(new CartItem(new ProductItem("asdf", 9.90, 1.0, false),1),
                        new CartItem(new ProductItem("Mouse XCB", 19.90, 1.0, false), 1),
                        new CartItem(new ProductItem("Vitamins D", 7.80, 6, false), 1));
        cart.setCartItemList(itemList);

        OrderInfo info = new OrderInfo(
                new Customer("Peter", Zone.NORTH_AMERICA, Level.NORMAL),
                new Recipient("Peter", Zone.NORTH_AMERICA),
                OrderInfo.ShippingPriority.STANDARD
                );

        Order order = orderService.checkout(cart, info);

        assertEquals(37.6, order.getTotalPrice(),0.1);
        assertEquals(10.0, order.getShipmentDetails().getShippingCosts());
        assertEquals(LocalDate.now().plusDays(3), order.getShipmentDetails().getDeliveryDate());
        assertEquals(LocalDate.now().plusDays(1), order.getShipmentDetails().getMaxShippingDate());
        assertEquals(7.8, order.getOrderItemList().get(2).getOrderPrice(),0.1);
        assertFalse(order.getShipmentDetails().isExpressShipment());
        assertEquals(TransportMode.TRUCK,order.getShipmentDetails().getTransportMode());
        assertEquals(9.9, order.getOrderItemList().get(0).getOrderPrice());
        assertEquals(19.9, order.getOrderItemList().get(1).getOrderPrice());
        assertEquals(false, order.getShipmentDetails().isDangerousGoods());

    }


    @Test
    public void checkoutTest_dangerousGoods_priorityStandard_zoneNorthAmerica_levelGold_noQuantityDiscount() {
        Checkout orderService = new Checkout();

        Cart cart = new Cart();
        List<CartItem> itemList =
                List.of(new CartItem(new ProductItem("Powerbank XTB123", 9.99, 1, true), 1),
                        new CartItem(new ProductItem("Mouse XCB", 19.90, 1, false), 1),
                        new CartItem(new ProductItem("Vitamins D", 7.80, 5, false), 1));
        cart.setCartItemList(itemList);

        OrderInfo info = new OrderInfo(
                new Customer("Peter", Zone.NORTH_AMERICA, Level.NORMAL),
                new Recipient("Peter", Zone.NORTH_AMERICA),
                OrderInfo.ShippingPriority.STANDARD
        );

        Order order = orderService.checkout(cart, info);

        assertEquals(37.69, order.getTotalPrice());
        assertEquals(10.0, order.getShipmentDetails().getShippingCosts());
        assertEquals(LocalDate.now().plusDays(3), order.getShipmentDetails().getDeliveryDate());
        assertEquals(LocalDate.now().plusDays(1), order.getShipmentDetails().getMaxShippingDate());
        assertEquals(7.8, order.getOrderItemList().get(2).getOrderPrice(),0.1);
        assertFalse(order.getShipmentDetails().isExpressShipment());
        assertEquals(TransportMode.TRUCK,order.getShipmentDetails().getTransportMode());
        assertEquals(9.99, order.getOrderItemList().get(0).getOrderPrice());
        assertEquals(19.9, order.getOrderItemList().get(1).getOrderPrice());
        assertEquals(true, order.getShipmentDetails().isDangerousGoods());

    }

    @Test
    public void checkoutTest_safeGoods_priorityNextDay_zoneNorthAmerica_levelGold_noQuantityDiscount() {
        Checkout orderService = new Checkout();

        Cart cart = new Cart();
        List<CartItem> itemList =
                List.of(new CartItem(new ProductItem("Powerbank XTB123", 9.99, 1, true), 1),
                        new CartItem(new ProductItem("Mouse XCB", 19.90, 1, false), 1),
                        new CartItem(new ProductItem("Vitamins D", 7.80, 2, false), 1));
        cart.setCartItemList(itemList);

        OrderInfo info = new OrderInfo(
                new Customer("Peter", Zone.NORTH_AMERICA, Level.NORMAL),
                new Recipient("Peter", Zone.NORTH_AMERICA),
                OrderInfo.ShippingPriority.NEXT_DAY
        );

        Order order = orderService.checkout(cart, info);

        assertEquals(37.69, order.getTotalPrice());
        assertEquals(18.0, order.getShipmentDetails().getShippingCosts());
        assertEquals(LocalDate.now().plusDays(1), order.getShipmentDetails().getDeliveryDate());
        assertEquals(LocalDate.now(), order.getShipmentDetails().getMaxShippingDate());
        assertEquals(7.8, order.getOrderItemList().get(2).getOrderPrice(),0.1);
        assertFalse(order.getShipmentDetails().isExpressShipment());
        assertEquals(TransportMode.AIR,order.getShipmentDetails().getTransportMode());
        assertEquals(9.99, order.getOrderItemList().get(0).getOrderPrice());
        assertEquals(19.9, order.getOrderItemList().get(1).getOrderPrice());
        assertEquals(true, order.getShipmentDetails().isDangerousGoods());

    }

}

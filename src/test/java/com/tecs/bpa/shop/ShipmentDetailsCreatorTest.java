package com.tecs.bpa.shop;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ShipmentDetailsCreatorTest {
    
    private ShipmentDetailsCreator task = new ShipmentDetailsCreator();

    
    @Test
    void testCorrectShipment() {

        Cart cart = new Cart();
        List<CartItem> itemList =
                List.of(new CartItem(new ProductItem("asdf", 9.90, 1.0, false),1),
                        new CartItem(new ProductItem("Mouse XCB", 19.90, 1.0, false), 1),
                        new CartItem(new ProductItem("Vitamins D", 7.80, 6, false), 1));
        cart.setCartItemList(itemList);

        OrderInfo info = new OrderInfo(
                new Customer("Peter", Zone.NORTH_AMERICA, CustomerLevel.NORMAL),
                new Recipient("Peter", Zone.NORTH_AMERICA),
                OrderInfo.ShippingPriority.STANDARD
        );

        ShipmentDetails shipmentDetails = task.getShipmentDetails(info, cart.getCartItemList());

        assertEquals(10.0, shipmentDetails.getShippingCosts());
        assertEquals(LocalDate.now().plusDays(3), shipmentDetails.getDeliveryDate());
        assertEquals(LocalDate.now().plusDays(1), shipmentDetails.getMaxShippingDate());
        assertFalse(shipmentDetails.isExpressShipment());
        assertEquals(TransportMode.TRUCK,shipmentDetails.getTransportMode());
        assertEquals(false, shipmentDetails.isDangerousGoods());
    }
    
    @Test
    void testCorrectShipmentNextDay() {
        Cart cart = new Cart();
        List<CartItem> itemList =
                List.of(new CartItem(new ProductItem("Powerbank XTB123", 9.99, 1, true), 1),
                        new CartItem(new ProductItem("Mouse XCB", 19.90, 1, false), 1),
                        new CartItem(new ProductItem("Vitamins D", 7.80, 2, false), 1));
        cart.setCartItemList(itemList);

        OrderInfo info = new OrderInfo(
                new Customer("Peter", Zone.NORTH_AMERICA, CustomerLevel.NORMAL),
                new Recipient("Peter", Zone.NORTH_AMERICA),
                OrderInfo.ShippingPriority.NEXT_DAY
        );

        ShipmentDetails shipmentDetails = task.getShipmentDetails(info, cart.getCartItemList());

        assertEquals(18.0, shipmentDetails.getShippingCosts());
        assertEquals(LocalDate.now().plusDays(1), shipmentDetails.getDeliveryDate());
        assertEquals(LocalDate.now(), shipmentDetails.getMaxShippingDate());
        assertFalse(shipmentDetails.isExpressShipment());
        assertEquals(TransportMode.AIR,shipmentDetails.getTransportMode());
        assertEquals(true, shipmentDetails.isDangerousGoods());
    }
}

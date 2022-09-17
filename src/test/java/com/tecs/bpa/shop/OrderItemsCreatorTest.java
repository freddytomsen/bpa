package com.tecs.bpa.shop;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class OrderItemsCreatorTest {

    private OrderItemsCreator orderItemsCreator = new OrderItemsCreator();
    
    @Test
    void createOrderItems() {
        Cart cart = new Cart();
        List<CartItem> itemList =
                List.of(new CartItem(new ProductItem("asdf", 9.90, 1.0, false),1),
                        new CartItem(new ProductItem("Mouse XCB", 19.90, 1.0, false), 1),
                        new CartItem(new ProductItem("Vitamins D", 7.80, 6, false), 1));
        cart.setCartItemList(itemList);

        List<OrderItem> orderItems = orderItemsCreator.createOrderItems(cart);

        assertEquals(7.8, orderItems.get(2).getOrderPrice(),0.1);
        assertEquals(9.9, orderItems.get(0).getOrderPrice());
        assertEquals(19.9, orderItems.get(1).getOrderPrice());

    }
}
package com.tecs.bpa.shop;

import com.tecs.bpa.customer.Customer;
import com.tecs.bpa.customer.CustomerLevel;
import com.tecs.bpa.order.OrderItemsCreator;
import com.tecs.bpa.order.OrderItemsDto;
import org.junit.jupiter.api.Test;

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
        Customer customer = new Customer("Peter", Zone.NORTH_AMERICA, CustomerLevel.NORMAL);

        OrderItemsDto orderItemsDto = orderItemsCreator.createOrderItems(cart, customer);

        assertEquals(7.8, orderItemsDto.getOrderItemList().get(2).getOrderPrice(),0.1);
        assertEquals(9.9, orderItemsDto.getOrderItemList().get(0).getOrderPrice());
        assertEquals(19.9, orderItemsDto.getOrderItemList().get(1).getOrderPrice());
        assertEquals(37.6, orderItemsDto.getTotalPrice(), 0.1);

    }
}
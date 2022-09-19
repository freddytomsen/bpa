package com.tecs.bpa.shop;

import com.tecs.bpa.customer.Customer;
import com.tecs.bpa.customer.CustomerLevel;
import com.tecs.bpa.order.*;

public class Checkout {


    private final ShipmentDetailsCreator shipmentDetailsCreator = new ShipmentDetailsCreator();
    private final TotalItemPriceCalculator totalItemPriceCalculator = new TotalItemPriceCalculator();
    private final OrderItemsCreator orderItemsCreator = new OrderItemsCreator();
    private final OrderCreator orderCreator = new OrderCreator();

    public Order checkout(Cart cart, OrderInfo orderInfo) {
        CustomerLevel customerLevel = orderInfo.getCustomer().getCustomerLevel();
        Customer customer = orderInfo.getCustomer();

        //Obtain shipment details like costs, delivery date and so on
        ShipmentDetails shipmentDetails = shipmentDetailsCreator.getShipmentDetails(orderInfo, cart.getCartItemList());

        //Create order items
        OrderItemsDto orderItems = orderItemsCreator.createOrderItems(cart, customerLevel);

        //Create and return order
        return orderCreator.createOrder(customer, shipmentDetails, orderItems);

    }

}

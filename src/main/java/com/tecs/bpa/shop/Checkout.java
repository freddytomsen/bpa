package com.tecs.bpa.shop;

import java.util.List;

public class Checkout {


    private final ShipmentDetailsCreator shipmentDetailsCreator = new ShipmentDetailsCreator();
    private final TotalItemPriceCalculator totalItemPriceCalculator = new TotalItemPriceCalculator();
    private final OrderItemsCreator orderItemsCreator = new OrderItemsCreator();
    private final OrderCreator orderCreator = new OrderCreator();

    public Order checkout(Cart cart, OrderInfo orderInfo) {
        Level level = orderInfo.getCustomer().getLevel();
        Customer customer = orderInfo.getCustomer();

        //Obtain shipment details like costs, delivery date and so on
        ShipmentDetails shipmentDetails = shipmentDetailsCreator.getShipmentDetails(orderInfo, cart.getCartItemList());

        //Create order items
        List<OrderItem> orderItemList = orderItemsCreator.createOrderItems(cart);

        //Calculate total order items price
        double totalOrderItemPrice = totalItemPriceCalculator.calculateTotalOrderItemPrice(level, orderItemList);

        //Create and return order
        return orderCreator.createOrder(customer, shipmentDetails, orderItemList, totalOrderItemPrice);

    }

}

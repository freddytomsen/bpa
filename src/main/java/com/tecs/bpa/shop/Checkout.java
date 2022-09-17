package com.tecs.bpa.shop;

import java.util.List;

public class Checkout {

    public static final double AMOUNT_DISCOUNT = 0.95;
    public static final double CUSTOMER_DISCOUNT = 0.9;
    private final ShipmentDetailsTask shipmentDetailsTask = new ShipmentDetailsTask();
    private final TotalItemPriceCalculator totalItemPriceCalculator = new TotalItemPriceCalculator();
    private final OrderItemsCreator orderItemsCreator = new OrderItemsCreator();
    private final OrderCreator orderCreator = new OrderCreator();

    public Order checkout(Cart cart, OrderInfo orderInfo) {
        Level level = orderInfo.getCustomer().getLevel();
        Customer customer = orderInfo.getCustomer();

        //Obtain shipment details like costs, delivery date and so on
        ShipmentDetails shipmentDetails = shipmentDetailsTask.getShipmentDetails(orderInfo, cart.getCartItemList());

        //Create order items
        List<OrderItem> orderItemList = orderItemsCreator.createOrderItems(cart);

        //Calculate total order items price
        double totalOrderItemPrice = totalItemPriceCalculator.calculateTotalOrderItemPrice(level, orderItemList);

        //Create and return order
        return orderCreator.createOrder(orderInfo, customer, shipmentDetails, orderItemList, totalOrderItemPrice);

    }

}

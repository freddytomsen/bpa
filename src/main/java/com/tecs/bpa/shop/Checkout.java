package com.tecs.bpa.shop;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Checkout {

    public static final double AMOUNT_DISCOUNT = 0.95;
    public static final double CUSTOMER_DISCOUNT = 0.9;

    public Order checkout(Cart cart, OrderInfo orderInfo) {
        Level level = orderInfo.getCustomer().getLevel();
        ShipmentDetails shipmentDetails = new ShipmentDetails();
        Customer customer = orderInfo.getCustomer();
        List<OrderItem> orderItemList = new ArrayList<>();

        for (CartItem item : cart.getCartItemList()) {
            double orderPrice;
            if (item.getAmount() > 5) {
                orderPrice = item.getProductItem().getPrice() * item.getAmount() * AMOUNT_DISCOUNT;
            } else {
                orderPrice = item.getProductItem().getPrice() * item.getAmount();
            }

            OrderItem orderItem = new OrderItem();
            orderItem.setOrderPrice(orderPrice);
            if (item.getProductItem().isDangerousGoods()) {
                shipmentDetails.setDangerousGoods(true);
            }
            orderItemList.add(orderItem);
        }

        double totalOrderItemPrice = orderItemList.stream().mapToDouble(o -> o.getOrderPrice()).sum();

        if (level == Level.GOLD) {
            totalOrderItemPrice = totalOrderItemPrice * CUSTOMER_DISCOUNT;
        }

        double shippingCosts;
        LocalDate deliveryDate;
        TransportMode transportMode;
        Order order = new Order();
        if (orderInfo.getRecipient().getWorldZone() == Zone.NORTH_AMERICA) {
            if (orderInfo.getShippingPriority() == OrderInfo.ShippingPriority.NEXT_DAY) {
                shipmentDetails.setMaxShippingDate(LocalDate.now());
                shippingCosts = 18.0;
                deliveryDate = LocalDate.now().plusDays(1);
                transportMode = TransportMode.AIR;
            } else {
                shippingCosts = 10.0;
                deliveryDate = LocalDate.now().plusDays(3);
                transportMode = TransportMode.TRUCK;
                shipmentDetails.setMaxShippingDate(LocalDate.now().plusDays(1));
            }

        } else {
                shippingCosts = 30.0;
                deliveryDate = LocalDate.now().plusDays(10);
                transportMode = TransportMode.AIR;
                shipmentDetails.setMaxShippingDate(LocalDate.now().plusDays(2));
        }

        order.setOrderItemList(orderItemList);
        order.setCustomer(customer);
        if (orderInfo.getRecipient() == null) {
            Recipient recipient = new Recipient(customer.getName(), customer.getWorldZone());
            shipmentDetails.setRecipient(recipient);
        } else {
            shipmentDetails.setRecipient(orderInfo.getRecipient());
        }
        order.setTotalPrice(totalOrderItemPrice);
        shipmentDetails.setDeliveryDate(deliveryDate);
        shipmentDetails.setShippingCosts(shippingCosts);
        shipmentDetails.setTransportMode(transportMode);
        order.setShipmentDetails(shipmentDetails);

        return order;
    }

}

package com.tecs.bpa.shop;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Checkout {

    public static final double AMOUNT_DISCOUNT = 0.95;
    public static final double CUSTOMER_DISCOUNT = 0.9;

    public Order checkout(Cart cart, OrderInfo orderInfo) {
        Level level = orderInfo.getCustomer().getLevel();
        Customer customer = orderInfo.getCustomer();

        //Obtain shipment details like costs, delivery date and so on
        ShipmentDetails shipmentDetails = getShipmentDetails(orderInfo);

        //Create order items
        List<OrderItem> orderItemList = getOrderItems(cart, shipmentDetails);

        //Calculate total order items price
        double totalOrderItemPrice = getTotalOrderItemPrice(level, orderItemList);

        //Create and return order
        return createOrder(orderInfo, customer, shipmentDetails, orderItemList, totalOrderItemPrice);

    }

    private Order createOrder(
            OrderInfo orderInfo, Customer customer, ShipmentDetails shipmentDetails,
            List<OrderItem> orderItemList, double totalOrderItemPrice) {
        Order order = new Order();
        order.setOrderItemList(orderItemList);
        order.setCustomer(customer);
        if (orderInfo.getRecipient() == null) {
            Recipient recipient = new Recipient(customer.getName(), customer.getWorldZone());
            shipmentDetails.setRecipient(recipient);
        } else {
            shipmentDetails.setRecipient(orderInfo.getRecipient());
        }
        order.setTotalPrice(totalOrderItemPrice);
        order.setShipmentDetails(shipmentDetails);
        return order;
    }

    private ShipmentDetails getShipmentDetails(OrderInfo orderInfo) {
        TransportMode transportMode;
        LocalDate deliveryDate;
        double shippingCosts;
        ShipmentDetails shipmentDetails = new ShipmentDetails();
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
        shipmentDetails.setDeliveryDate(deliveryDate);
        shipmentDetails.setShippingCosts(shippingCosts);
        shipmentDetails.setTransportMode(transportMode);
        return shipmentDetails;
    }

    private double getTotalOrderItemPrice(Level level, List<OrderItem> orderItemList) {
        double totalOrderItemPrice = orderItemList.stream().mapToDouble(o -> o.getOrderPrice()).sum();

        if (level == Level.GOLD) {
            totalOrderItemPrice = totalOrderItemPrice * CUSTOMER_DISCOUNT;
        }
        return totalOrderItemPrice;
    }

    private List<OrderItem> getOrderItems(Cart cart, ShipmentDetails shipmentDetails) {
        List<OrderItem> orderItemList = new ArrayList<>();
        cart.getCartItemList().stream().forEach(p -> {
            double orderPrice;
            if (p.getAmount() > 5) {
                orderPrice = p.getProductItem().getPrice() * p.getAmount() * AMOUNT_DISCOUNT;
            } else {
                orderPrice = p.getProductItem().getPrice() * p.getAmount();
            }
            OrderItem orderItem = new OrderItem();
            orderItem.setOrderPrice(orderPrice);
            if (p.getProductItem().isDangerousGoods()) {
                shipmentDetails.setDangerousGoods(true);
            }
            orderItemList.add(orderItem);
        });
        return orderItemList;
    }

}

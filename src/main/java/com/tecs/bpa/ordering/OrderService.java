package com.tecs.bpa.ordering;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class OrderService {

    public Order checkout(Cart cart, ShipmentInfo shipmentInfo) {
        Level level = shipmentInfo.getCustomer().getLevel();

        List<OrderItem> orderItemList = new ArrayList<>();
        cart.getCartItemList().stream().forEach(p -> {
            double orderPrice;
            if (p.getAmount() > 5) {
                orderPrice = p.getPrice() * p.getAmount() * 0.95;
            } else {
                orderPrice = p.getPrice() * p.getAmount();
            }
            OrderItem orderItem = new OrderItem();
            orderItem.setOrderPrice(orderPrice);
            orderItemList.add(orderItem);
        });

        double totalOrderItemPrice = orderItemList.stream().mapToDouble(o -> o.getOrderPrice()).sum();

        if (level == Level.GOLD) {
            totalOrderItemPrice = totalOrderItemPrice * 0.9;
        }

        double shippingCosts;
        LocalDate deliveryDate;
        if (shipmentInfo.getCustomer().getWorldZone() == Zone.NORTH_AMERICA) {
            if (shipmentInfo.isExpressShipment()) {
                shippingCosts = 18.0;
                deliveryDate = LocalDate.now().plusDays(1);
            } else {
                shippingCosts = 10.0;
                deliveryDate = LocalDate.now().plusDays(3);
            }

        } else {
            if (shipmentInfo.isExpressShipment()) {
                shippingCosts = 50.0;
                deliveryDate = LocalDate.now().plusDays(20);

            } else {
                shippingCosts = 30.0;
                deliveryDate = LocalDate.now().plusDays(10);

            }

        }

        Order order = new Order();
        order.setOrderItemList(orderItemList);
        order.setCustomer(shipmentInfo.getCustomer());
        order.setRecipient(shipmentInfo.getRecipient());
        order.setTotalPrice(totalOrderItemPrice);
        order.setShippingCosts(shippingCosts);
        order.setDeliveryDate(deliveryDate);

        return order;
    }

}

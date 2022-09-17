package com.tecs.bpa.shop;

import java.time.LocalDate;
import java.util.List;

public class ShipmentDetailsTask {
    public ShipmentDetailsTask() {
    }

    ShipmentDetails getShipmentDetails(OrderInfo orderInfo, List<CartItem> cartItemList) {
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
        boolean atLeastOneIsDangerousGoods = cartItemList.stream().anyMatch(item -> item.getProductItem().isDangerousGoods());
        shipmentDetails.setDangerousGoods(atLeastOneIsDangerousGoods);
        shipmentDetails.setDeliveryDate(deliveryDate);
        shipmentDetails.setShippingCosts(shippingCosts);
        shipmentDetails.setTransportMode(transportMode);
        return shipmentDetails;
    }
}
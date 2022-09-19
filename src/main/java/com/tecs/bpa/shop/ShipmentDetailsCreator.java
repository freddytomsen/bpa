package com.tecs.bpa.shop;

import com.tecs.bpa.order.OrderInfo;

import java.time.LocalDate;
import java.util.List;

public class ShipmentDetailsCreator {
    public ShipmentDetailsCreator() {
    }

    ShipmentDetails getShipmentDetails(OrderInfo orderInfo, List<CartItem> cartItemList) {
        TransportMode transportMode;
        LocalDate deliveryDate;
        LocalDate maxShippingDate = LocalDate.now();
        double shippingCosts;
        ShipmentDetails shipmentDetails = new ShipmentDetails();
        if (orderInfo.getRecipient().getWorldZone() == Zone.NORTH_AMERICA) {
            if (orderInfo.getShippingPriority() == OrderInfo.ShippingPriority.NEXT_DAY) {
                deliveryDate = LocalDate.now().plusDays(1);
                shippingCosts = 18.0;
                transportMode = TransportMode.AIR;
            } else {
                shippingCosts = 10.0;
                deliveryDate = LocalDate.now().plusDays(3);
                transportMode = TransportMode.TRUCK;
                maxShippingDate = LocalDate.now().plusDays(1);
            }

        } else {
            shippingCosts = 30.0;
            deliveryDate = LocalDate.now().plusDays(10);
            transportMode = TransportMode.AIR;
            maxShippingDate = LocalDate.now().plusDays(2);
        }

        if (orderInfo.getRecipient() == null) {
            Recipient recipient = new Recipient(orderInfo.getCustomer().getName(),
                    orderInfo.getCustomer().getWorldZone());
            shipmentDetails.setRecipient(recipient);
        } else {
            shipmentDetails.setRecipient(orderInfo.getRecipient());
        }

        boolean atLeastOneIsDangerousGoods = cartItemList.stream().anyMatch(item -> item.getProductItem().isDangerousGoods());
        shipmentDetails.setDangerousGoods(atLeastOneIsDangerousGoods);

        shipmentDetails.setDeliveryDate(deliveryDate);
        shipmentDetails.setMaxShippingDate(maxShippingDate);

        shipmentDetails.setShippingCosts(shippingCosts);
        shipmentDetails.setTransportMode(transportMode);
        return shipmentDetails;
    }
}
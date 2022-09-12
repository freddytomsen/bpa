package com.tecs.bpa.shop;

import lombok.Data;

import java.time.LocalDate;

@Data
public class ShipmentDetails {

    private LocalDate maxShippingDate;
    private LocalDate deliveryDate;
    private boolean expressShipment;
    private boolean dangerousGoods;
    private Recipient recipient;
    private TransportMode transportMode;
    private Double shippingCosts;

}

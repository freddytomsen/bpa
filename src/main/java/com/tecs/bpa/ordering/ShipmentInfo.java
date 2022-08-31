package com.tecs.bpa.ordering;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ShipmentInfo {

    private Customer customer;
    private Recipient recipient;

    private boolean expressShipment;

}

package com.tecs.bpa.shop;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class OrderInfo {

    private Customer customer;
    private Recipient recipient;
    private ShippingPriority shippingPriority;

    enum ShippingPriority {
        STANDARD, NEXT_DAY;
    }

}

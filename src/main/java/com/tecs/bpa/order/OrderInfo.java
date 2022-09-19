package com.tecs.bpa.order;

import com.tecs.bpa.customer.Customer;
import com.tecs.bpa.shop.Recipient;
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

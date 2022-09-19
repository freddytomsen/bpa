package com.tecs.bpa.order;

import com.tecs.bpa.customer.Customer;
import com.tecs.bpa.shop.ShipmentDetails;
import lombok.Data;

import java.util.List;
@Data
public class Order {

    private Customer customer;

    private List<OrderItem> orderItemList;

    private Double totalPrice;

    private ShipmentDetails shipmentDetails;

}

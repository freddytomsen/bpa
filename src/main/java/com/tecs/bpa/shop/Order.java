package com.tecs.bpa.shop;

import lombok.Data;

import java.util.List;
@Data
public class Order {

    private Customer customer;

    private List<OrderItem> orderItemList;

    private Double totalPrice;

    private ShipmentDetails shipmentDetails;

}

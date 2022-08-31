package com.tecs.bpa.ordering;

import lombok.Data;

import java.time.LocalDate;
import java.util.List;
@Data
public class Order {

    private Customer customer;

    private Recipient recipient;

    private List<OrderItem> orderItemList;

    private Double totalPrice;

    private Double shippingCosts;

    private LocalDate deliveryDate;


}

package com.tecs.bpa.customer;

import com.tecs.bpa.shop.Zone;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Customer {

    private String name;

    private Zone worldZone;

    private CustomerLevel customerLevel;

}

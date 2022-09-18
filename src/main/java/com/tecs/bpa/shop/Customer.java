package com.tecs.bpa.shop;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Customer {

    private String name;

    private Zone worldZone;

    private CustomerLevel customerLevel;

}

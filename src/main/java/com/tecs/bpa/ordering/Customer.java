package com.tecs.bpa.ordering;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Customer {

    private String name;

    private Zone worldZone;

    private Level level;

}

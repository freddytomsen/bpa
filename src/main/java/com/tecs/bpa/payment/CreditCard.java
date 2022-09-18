package com.tecs.bpa.payment;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CreditCard {

    private String name;
    private String bank;
    private String country;
    private String creditCardNumber;
    private int expirationMonth;
    private int expirationYear;
    private Operator operator;

    public enum Operator {
        VISA, MASTERCARD, AMERICAN_EXPRESS, DISCOVER;
    }

}

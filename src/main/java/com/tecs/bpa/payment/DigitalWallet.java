package com.tecs.bpa.payment;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class DigitalWallet {

    private String email;
    private String name;
    private Provider provider;

    public enum Provider {
        APPLE_PAY, GOOGLE_PAY
    }
}

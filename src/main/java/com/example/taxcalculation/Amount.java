package com.example.taxcalculation;

import java.math.BigInteger;

public class Amount {
    private final BigInteger amount;
    private final CurrencyType currencyType;

    public Amount(BigInteger amount, CurrencyType currencyType) {
        this.amount = amount;
        this.currencyType = currencyType;
    }

    public BigInteger getAmount() {
        return amount;
    }

    public CurrencyType getCurrencyType() {
        return currencyType;
    }

    public  enum CurrencyType{
        USD,
        INR,
        DINAR
    }
}

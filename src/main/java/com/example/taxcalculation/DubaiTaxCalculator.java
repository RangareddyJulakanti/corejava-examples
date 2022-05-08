package com.example.taxcalculation;

import java.math.BigInteger;

public class DubaiTaxCalculator implements ITaxCalculation{
    @Override
    public Amount calculate(Employee employee) {
        BigInteger taxAmount= employee.getSalary().getAmount()
                .divide(new BigInteger("100"))
                .multiply(new BigInteger("40"));
        return new Amount(taxAmount,employee.getSalary().getCurrencyType());
    }
}

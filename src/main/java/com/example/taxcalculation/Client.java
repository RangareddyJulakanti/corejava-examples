package com.example.taxcalculation;

import java.math.BigInteger;
import java.util.*;

public class Client {
    public static void main(String[] args) {


        Map<String, ITaxCalculation> taxCalculationMap = new HashMap<>();

        taxCalculationMap.put("IN", new IndianTaxCalculator());
        taxCalculationMap.put("US", new USTaxCalculator());
        List<Employee> employeeList = getEmployeeListFromDB();


        for (Employee employee : employeeList) {
            ITaxCalculation iTaxCalculation = taxCalculationMap.get(employee.getEmployeeType().name());
            //  ITaxCalculation iTaxCalculation=taxCalculation(employee.getCountry().name());
            if (iTaxCalculation == null) {
                throw new RuntimeException("Invalid countryType= " + employee.getEmployeeType().name());
            }
            Amount amount = iTaxCalculation.calculate(employee);
            System.out.println("taxAmount= " + amount.getAmount() + " currencyType= " + amount.getCurrencyType().name());
        }


    }

    private static List<Employee> getEmployeeListFromDB() {
       return Arrays.asList(
                new Employee(
                        "ranga",
                        Employee.EmployeeType.PERMANENT,
                        new Amount(new BigInteger("200000"), Amount.CurrencyType.INR),
                        Country.IN
                ),
                new Employee(
                        "raju",
                        Employee.EmployeeType.CONTRACT,
                        new Amount(new BigInteger("60000"), Amount.CurrencyType.USD),
                        Country.US
                )
        );
    }

    private static ITaxCalculation taxCalculation(String countryType) {
        if (countryType.equalsIgnoreCase("IN")) {
            return new IndianTaxCalculator();
        } else if (countryType.equalsIgnoreCase("US")) {
            return new USTaxCalculator();
        } else {
            throw new RuntimeException("Invalid countryType");
        }
    }

}

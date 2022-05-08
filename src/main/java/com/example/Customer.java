package com.example;

import java.io.Serializable;
 
public class Customer implements Serializable {
 
    // member variables
    final int customerId;
    transient final String customerName;
    transient final int customerAge = 10;
    transient int customerSSN;
 
    // 3-arg parameterized constructor 
    public Customer(int customerId, String customerName,
            int customerSSN) {
        this.customerId = customerId;
        this.customerName = customerName; // final transient
        this.customerSSN = customerSSN;
    }
 
    // overriding toString() method
    @Override
    public String toString() {
        return "Customer ["
                + "customerId=" + customerId 
                + ", customerName=" + customerName 
                + ", customerAge=" + customerAge
                + ", customerSSN=" + customerSSN
                + "]";
    }
}
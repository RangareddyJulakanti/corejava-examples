package com.example.taxcalculation;

public class Employee {

    private final String name;
    private final EmployeeType employeeType;
    private final Amount salary;
    private final Country country;

    public Employee(String name, EmployeeType employeeType, Amount salary, Country country) {
        this.name = name;
        this.employeeType = employeeType;
        this.salary = salary;
        this.country = country;
    }

    public String getName() {
        return name;
    }

    public EmployeeType getEmployeeType() {
        return employeeType;
    }

    public Amount getSalary() {
        return salary;
    }

    public Country getCountry() {
        return country;
    }

    public enum EmployeeType{
        PERMANENT,
        CONTRACT
    }
}

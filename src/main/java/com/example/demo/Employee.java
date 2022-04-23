package com.example.demo;

import lombok.Data;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;

@Data
public class Employee {
    @NotNull
    private final int id;
    @NotNull
    private final String fname;
    @NotNull
    private final String lname;

    @NotNull
    @Email
    private final String email;
}

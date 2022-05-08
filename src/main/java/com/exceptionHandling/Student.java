package com.exceptionHandling;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;


public class Student {

    @JsonProperty("id")
    private  Integer id;

    @JsonProperty("name")
    private  String name;

    @JsonProperty("collegeName")
    private  String collegeName;
    public Student(){

    }
    public Student(Integer id, String name, String collegeName) {
        this.id = id;
        this.name = name;
        this.collegeName = collegeName;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getCollegeName() {
        return collegeName;
    }
}
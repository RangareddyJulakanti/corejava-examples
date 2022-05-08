package com.exceptionHandling;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Test {
    public static void main(String[] args) {

        List<Student> studentList = getDataFromUI();
        List<Student> validStudentData = new ArrayList<>();
        List<String> errorMessageList = new ArrayList<>();

        for (Student student : studentList) {
            ErrorMessage errorMessage = validateAllStudents(student);
            if (Objects.nonNull(errorMessage)) {
                errorMessageList.add(errorMessage.getErrorMessage());
            } else {
                validStudentData.add(student);
            }
        }
        printInvalidData(errorMessageList);
        persistStudentDataIntoDB(validStudentData);
    }

    private static void printInvalidData(List<String> errorMessageList) {
        errorMessageList.forEach(System.out::println);
    }

    private static void persistStudentDataIntoDB(List<Student> studentList) {
        System.out.println("Valid Student details");
        for (Student student : studentList) {
            System.out.println("StudentId" + student.getId() + " StudentName =  " + student.getName() + "CollegeName= " + student.getCollegeName());
        }
    }

    private static ErrorMessage validateAllStudents(Student student) {

        if (StringUtils.isEmpty(student.getCollegeName())) {
            ErrorMessage errorMessage = new ErrorMessage();
            errorMessage.setErrorMessage("Invalid collegeName = " + student.getCollegeName() + " for the Student id= " + student.getId());
            errorMessage.setErrorCode("BAD Request");
            return errorMessage;
        }
        if (StringUtils.isEmpty(student.getName())) {
            ErrorMessage errorMessage = new ErrorMessage();
            errorMessage.setErrorMessage("Invalid studentName = " + student.getName() + " for the Student id= " + student.getId());
            errorMessage.setErrorCode("BAD Request");
            return errorMessage;
        }
        return null;
    }

    private static List<Student> getDataFromUI() {
        String jsonString="[{\"id\":1,\"name\":\"ranga\",\"collegeName\":\"JNTU\"},{\"id\":2,\"name\":\"RAJU\",\"collegeName\":\"\"},{\"id\":3,\"name\":\"MOHAN\",\"collegeName\":\"PULLAREDDY\"},{\"id\":4,\"name\":\"\",\"collegeName\":\"RAYALASEEMA UNIVERSITY\"}]";

        ObjectMapper o=new ObjectMapper();
        try {
           List<Student> l= o.readValue(jsonString,  new TypeReference<List<Student>>() {
           });
           return l;
        } catch (JsonProcessingException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }
}


package com.exceptionHandling;

import com.google.common.io.Files;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

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
        return Arrays.asList(
                new Student(1, "ranga", "A"),
                new Student(2, "raju", null),
                new Student(3, "mohan", "C"),
                new Student(4, "", "D")
        );
    }
}

class Student {
    private final int id;
    private final String name;
    private final String collegeName;

    public Student(int id, String name, String collegeName) {
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
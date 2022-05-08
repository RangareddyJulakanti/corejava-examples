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
import java.util.stream.Collectors;

public class Test {
    public static void main(String[] args) {
      List<Student> studentList=getDataFromUI();

      Fault fault=validateAllStudents(studentList);

      if(CollectionUtils.isEmpty(fault.getErrorMessages())) {
          persistStudentDataIntoDB(studentList);
      }else{
          List<String> errorMessageList=new ArrayList<>();
          for(ErrorMessage errorMessage:fault.errorMessages){
              errorMessageList.add(errorMessage.getErrorMessage());
          }
         String totalMessages= errorMessageList.stream().collect(Collectors.joining("\n"));
         throw  new RuntimeException(totalMessages);
      }
    }

    private static void persistStudentDataIntoDB(List<Student> studentList) {
        System.out.println("Valid Student details");
        for (Student student: studentList) {
            System.out.println("StudentId"+student.getId()+" StudentName =  "+student.getName()+"CollegeName= "+student.getCollegeName());
        }
    }

    private static  Fault  validateAllStudents(List<Student> studentList) {
        Fault fault=new Fault();
        for(Student student:studentList){
            if(StringUtils.isEmpty(student.getCollegeName())){
                ErrorMessage errorMessage=new ErrorMessage();
                errorMessage.setErrorMessage("Invalid collegeName = " +student.getCollegeName() + " for the Student id= "+student.getId());
                errorMessage.setErrorCode("BAD Request");
                fault.addErrorMessage(errorMessage);
            }
            if(StringUtils.isEmpty(student.getName())){
                ErrorMessage errorMessage=new ErrorMessage();
                errorMessage.setErrorMessage("Invalid studentName = " +student.getName() + " for the Student id= "+student.getId());
                errorMessage.setErrorCode("BAD Request");
                fault.addErrorMessage(errorMessage);
            }
        }
        return fault;
    }

    private static List<Student> getDataFromUI() {
        return Arrays.asList(
                new Student(1,"ranga","A"),
                new Student(2,"raju",null),
                new Student(3,"mohan","C"),
                new Student(4,"","D")
        );
    }
}
class Student{
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
package com.exceptionHandling;

import java.util.ArrayList;
import java.util.List;

public class Fault {
    List<ErrorMessage> errorMessages=new ArrayList<>(0);

    public void addErrorMessage(ErrorMessage errorMessage){
        errorMessages.add(errorMessage);
    }
    public List<ErrorMessage> getErrorMessages(){
        return errorMessages;
    }
}

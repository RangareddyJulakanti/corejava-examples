package com.example;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Test {
    public static void main(String[] args) {

        Map<Integer,Long> map=IntStream
                .of(1, 2, 3, 1, 2, 5, 6, 5, 3)
                .boxed()
                .collect(
                        Collectors.groupingBy(Function.identity(), Collectors.counting())
                );
        Map<String,Long> map1= Stream.of("ranga","raju","kiran","ranga")
                .collect(Collectors.groupingBy(Function.identity(),Collectors.counting()));

        System.out.println(map1);
        //Print index of 40
        int a[]={10,20,30,40,50,60};
        int requiredIndex=-1;
        for(int index=0;index<a.length-1;index++){
            if(a[index]==40){
                requiredIndex=index;
                break;
            }
        }
        if(requiredIndex!=-1) {
            System.out.println("found the given value in array index=="+requiredIndex);
        }else{
            System.out.println("Not found");
        }


/*

        int c[]={40,50,10,30,60,20};

        for(int i=0;i<c.length-1;i++){
            int x=c[i];
            for(int j=i+1;j< c.length-1;j++){
                if(x>c[j]){
                    int temp=x;
                    x=c[j];
                    c[j]=temp;
                }
            }
        }*/

        String statment="Hai this is Mohan Hai this is Raghu";
        Map<String,Long> map3=Arrays.stream(statment.split(" "))
                .collect(Collectors.groupingBy(Function.identity(),Collectors.counting()));
        System.out.println(map3);



























    }
}

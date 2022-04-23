package com.example.demo;

import java.util.HashMap;
import java.util.Map;

public class BeanFactory {
    Map<Class,Object> cache=new HashMap<>();
    public Object getBean(Class clazz) throws InstantiationException, IllegalAccessException {
        if(cache.get(clazz)!=null){
            return cache.get(clazz);
        }else{
           Object obj= clazz.newInstance();
           createBean(obj);
           return obj;
        }
    }
    public void createBean(Object object){
        cache.put(object.getClass(),object);
    }

}

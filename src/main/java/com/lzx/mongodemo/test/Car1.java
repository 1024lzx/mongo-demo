package com.lzx.mongodemo.test;

import org.springframework.context.annotation.Primary;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@Order(2)
public class Car1 implements Car{
    public Car1(){
        System.out.println("car1 build");
    }
}

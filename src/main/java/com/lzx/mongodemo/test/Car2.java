package com.lzx.mongodemo.test;

import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@Order(1)
public class Car2 implements Car{
    public Car2(){
        System.out.println("car2 build");
    }
}

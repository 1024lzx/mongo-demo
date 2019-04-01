package com.lzx.mongodemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@SpringBootApplication
public class MongoDemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(MongoDemoApplication.class, args);
    }

}

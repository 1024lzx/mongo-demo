package com.lzx.mongodemo;

import org.jasypt.encryption.StringEncryptor;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MongoDemoApplicationTests {
    @Autowired
    private StringEncryptor encryptor;

    @Test
    public void contextLoads() {
    }

    @Test
    public void encode(){
        System.out.println("username:"+encryptor.encrypt("root"));
        System.out.println("password:"+encryptor.encrypt("1994"));

    }
}

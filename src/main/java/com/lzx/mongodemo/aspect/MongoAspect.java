package com.lzx.mongodemo.aspect;

import lombok.extern.slf4j.Slf4j;
import org.aopalliance.intercept.Joinpoint;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.*;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Aspect
@Component
@Order(1)
public class MongoAspect {
    @Pointcut("execution(public * com.lzx.mongodemo.web.MongoController.*(..))")
    public void p1(){}

    @Pointcut("@target(org.springframework.web.bind.annotation.PathVariable)")
    public void p2(){}

    @Pointcut("args(org.springframework.web.multipart.MultipartFile)")
    public void p3(){}



    /*@Before("p2()")
    public void before2(){
        System.out.println("before1-1");
    }*/

    @Before("p1()")
    public void before1(JoinPoint joinPoint) throws Throwable {
        System.out.println(joinPoint.getTarget().getClass());
        System.out.println("before");
    }

    @AfterReturning(pointcut = "p1()",returning = "returnValue")
    public void afterReturning(JoinPoint joinPoint,Object returnValue){
        ((List<String>)returnValue).add("test");
        System.out.println("afterReturning");
    }

    @AfterThrowing("p1()")
    public void afterThrowing(){
        System.out.println("afterThrowing");
    }

    @After("p1()")
    public void after(){
        System.out.println("after");
    }

    @Around("p1()")
    public Object around(ProceedingJoinPoint joinPoint) throws Throwable {
        System.out.println("around-before");
        Object object = joinPoint.proceed();
        System.out.println("around-after");
        return object;
    }




    /*@Before("p1()")
    public void before2(JoinPoint joinPoint) throws Throwable {
        System.out.println("before2");
    }

    @AfterReturning("p1()")
    public void afterReturning2(){
        System.out.println("afterReturning2");
    }

    @AfterThrowing("p1()")
    public void afterThrowing2(){
        System.out.println("afterThrowing2");
    }

    @After("p1()")
    public void after2(){
        System.out.println("after2");
    }

    @Around("p1()")
    public void around2(ProceedingJoinPoint joinPoint) throws Throwable {
        System.out.println("around-before2");
        joinPoint.proceed();
        System.out.println("around-after2");
    }*/





}

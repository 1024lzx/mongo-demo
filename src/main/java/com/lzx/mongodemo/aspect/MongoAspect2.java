package com.lzx.mongodemo.aspect;

import org.aopalliance.intercept.Joinpoint;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Order(2)
public class MongoAspect2 {
    @Pointcut("execution(public * com.lzx.mongodemo.web.MongoController.*(..))")
    public void p1(){}

    @Before("p1()")
    public void before2(JoinPoint joinPoint) throws Throwable {
        System.out.println(joinPoint.getTarget().getClass());
        System.out.println("before2");
    }

    @AfterReturning(pointcut = "p1()",returning = "returnValue")
    public void afterReturning2(JoinPoint joinpoint,Object returnValue){
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
    public Object around2(ProceedingJoinPoint joinPoint) throws Throwable {
        System.out.println("around-before2");
        Object object = joinPoint.proceed();
        System.out.println("around-after2");
        return object;
    }
}

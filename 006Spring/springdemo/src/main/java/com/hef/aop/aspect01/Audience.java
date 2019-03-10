package com.hef.aop.aspect01;

import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

/**
 * 定义切面
 */
@Aspect
public class Audience {

    @Before("execution(* com.hef.aop.Performance.perform(..))")
    public void silenceCellPhones(){
        System.out.println("Silencing cell phones");
    }

    @Before("execution(* com.hef.aop.Performance.perform(..))")
    public void takeSeats(){
        System.out.println("Taking seats");
    }

    @AfterReturning("execution(* com.hef.aop.Performance.perform(..))")
    public void applause(){
        System.out.println("CLAP CLAP CLAP!!!");
    }

    @AfterThrowing("execution(* com.hef.aop.Performance.perform(..))")
    public void demandRefund(){
        System.out.println("Demanding a refund");
    }
}

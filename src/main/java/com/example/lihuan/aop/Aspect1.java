package com.example.lihuan.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

public class Aspect1
{

    public void before()
    {
        System.out.println("前置通知");
    }

    public void around(ProceedingJoinPoint point) throws Throwable
    {
        System.out.println("环绕通知前");
        point.proceed();
        System.out.println("环绕通知后");

    }

    public void after()
    {
        System.out.println("后置通知");
    }
}

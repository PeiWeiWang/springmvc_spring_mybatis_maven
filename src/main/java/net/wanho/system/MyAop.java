package net.wanho.system;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class MyAop {

    @Around("execution(* net.wanho.service.*.*(..))")
    public Object myarond(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        System.out.println("MyAop.myarond---------------------------");
        return proceedingJoinPoint.proceed();
    }
}

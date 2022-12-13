package org.example.aspects;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

import java.util.ArrayList;

@Aspect
@Component
public class AroundAspect {
    @Around("execution(public * findUser(String))")
    public Object aroundFindUsers(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        System.out.println("We are starting  searching - It is code from aspect");
        long beginTime = System.currentTimeMillis();
        Object targetResult;
        try {
            targetResult = proceedingJoinPoint.proceed();
        } catch (IllegalArgumentException e) {  // we can hand with exception
            System.out.println(e.getMessage());
            targetResult = new ArrayList<>();
        }
        Thread.sleep(100);
        long time = System.currentTimeMillis() - beginTime;
        System.out.println("We are finished searching. Time took millisecond: " + time + ". It is code from aspect");
        return targetResult;
    }
}

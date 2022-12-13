package org.example.aspects;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.example.entities.User;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.stream.Collectors;

@Component
@Aspect
public class AfterReturningAspect {

    // we can change result!

    @AfterReturning(pointcut = "execution(* addUser(org.example.entities.User))", returning ="result" )
    private void afterAddUserLoggingAdvice(JoinPoint joinPoint, boolean result) {
        Object[] objects = joinPoint.getArgs();
        User user = (User) Arrays.stream(objects).filter(x -> x instanceof User).collect(Collectors.toList()).get(0);
        System.out.println("User " + user.toString() + " added successfully result is " + result );
    }
}

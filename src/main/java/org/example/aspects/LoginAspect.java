package org.example.aspects;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoginAspect {

    @Before("execution(public org.example.entities.Item getItem(String))") // this is point cut
    public void printLogBefore() {              // this is advice
        System.out.println("Do logging before");
    }
}

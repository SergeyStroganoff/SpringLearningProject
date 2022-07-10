package org.example.aspects;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class AfterAspect {
    @After("execution(public * org.example.entities.*.deleteUser(org.example.entities.User))")
    // pointcut for all methods deleteUser in org.example.entities Package
    public void closeResources() {
        System.out.println("All resourced were closed - It is code from aspect");
    }
}

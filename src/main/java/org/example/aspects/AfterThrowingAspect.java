package org.example.aspects;

import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class AfterThrowingAspect {

    @AfterThrowing(pointcut = "execution(public * delete*(..))", throwing = "exception")
    public void afterTrowingLodging(Throwable exception) {
        System.out.println("We've got an Exception: \"" + exception.getMessage() + "\" during deleting employer from department");
    }

}

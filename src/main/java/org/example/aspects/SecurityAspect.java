package org.example.aspects;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.junit.jupiter.api.Order;
import org.springframework.stereotype.Component;

@Component
@Aspect
@Order(2)
public class SecurityAspect {

    @Pointcut("execution(* org.example.entities.Item.*(..))") // point cut for all methods from Item class
    private void methodsFromItem() {
    }

    @Pointcut("execution(public  *  *(String))")
    private void methodsWithStringParam() {
    }

    @Pointcut("execution(public  *  *(org.example.entities.Item))")
    private void methodsWithItemParam() {
    }

    @Before("methodsWithStringParam() || methodsWithItemParam()") // combination pointcuts
    public void doSecurity() {
        System.out.println("Check user rights - It is code from aspect");
    }
}

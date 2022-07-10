package org.example.aspects;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.junit.jupiter.api.Order;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Aspect
@Component
@Order(1) // order of pointcuts running
public class LoginAspect {

    @Pointcut("execution(public * add*(..))") // Pointcut declaration
    private void allAddMethods() {
    }

    // this is advice
    //  @Before("execution(public  org.example.entities.Item   getItem(String))") // this is point cut for all classes with method get Item
    @Before("execution(public  org.example.entities.Item  org.example.entities.WarehouseImpl.getItem(String))")
    //  point cut for exact class
    public void printLogBefore() {              // this is advice
        System.out.println("Do logging before");
    }

    //@After("execution(public * add*(org.example.entities.Item))") // point cut with wildcard
    @After("execution(public * add*(..))") // point cut with dots - any parameters
    public void printLogAfterAdd(JoinPoint joinPoint) {
        System.out.println("We try to get parameters from method");
        MethodSignature methodSignature = (MethodSignature) joinPoint.getSignature();
        System.out.println("methodSignature.getMethod() " + methodSignature.getMethod());
        System.out.println("methodSignature.getReturnType() " + methodSignature.getReturnType());
        System.out.println("methodSignature.getName() " + methodSignature.getName());
        if (methodSignature.getName().equals("addItem")) {
            Object[] objects = joinPoint.getArgs();
            Arrays.stream(objects).forEach(System.out::println);
        }
        System.out.println("We added some item");
    }

    @After("allAddMethods()") // point cut with dots - any parameters
    public void freeResourcesAfterAdd() {
        System.out.println("We free resources");
    }
}

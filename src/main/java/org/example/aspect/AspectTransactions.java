package org.example.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class AspectTransactions {

    @Around("execution(* org.example.repository.EmployeeDAOImpl.*(..) )")
    public Object aroundAllRepositoryMethodsAdvice(ProceedingJoinPoint pjp) throws Throwable {
        System.out.println("Start transaction");
        Object targetResult = pjp.proceed();
        System.out.println("End transaction");
        return targetResult;
    }
}

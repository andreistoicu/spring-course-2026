package org.example.aop;

import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class ServiceCreateAspect {

    @Pointcut("execution(* org.example.service.BookService.saveBook(..))")
    public void bookSavePointcut(){
    }

    @Before("bookSavePointcut()")
    public void beforeSaveBook(){
        System.out.println("[AOP------------------] BEFORE save book aspect --------------------");
    }

    @AfterReturning("bookSavePointcut()")
    public void afterSaveBook(){
        System.out.println("[AOP------------------] AFTER save book aspect --------------------");
    }
}

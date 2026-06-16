package org.example;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

@Service
@Scope("prototype")
//@Scope("singleton")
public class Bean11 {

    private double randomNo;

    public Bean11() {
        randomNo = Math.random();
        System.out.println("bean11 constructor" +  randomNo);
    }

    void  doSomethingElse() {
        System.out.println("doSomethingElse was initiated from bean11");
    }

    public double getRandomNo() {
        return randomNo;
    }

}

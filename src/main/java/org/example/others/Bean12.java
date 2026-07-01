package org.example.others;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;

@Service
public class Bean12 {

    private NoBean nobean;

    @Autowired(required = false) //->usage only for Field and Setter Injection
    //setter injection
    public void setBean7(NoBean nobean) {
        this.nobean = nobean;
    }

    public Bean12() {
        System.out.println("bean9 constructor");
    }

    @PostConstruct
    void doSomethingElse() {
        System.out.println("bean7 doSomething was initiated ");
        if(nobean != null) {
            nobean.doSomethingElse();
        } else {
            System.out.println("ATTENTION - -- -- -- - -bean11 is null");
        }
    }

}

package org.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;

@Service
//setter injection
public class Bean9 {

    private Bean7 bean7;
    private Bean11 bean11;

    public Bean9() {
        System.out.println("bean9 constructor");
    }

    @Autowired
    //setter injection
    public void setBean7(Bean7 bean7, Bean11 bean11) {
        this.bean7 = bean7;
        this.bean11 = bean11;
    }

    @PostConstruct
    void doSomethingElse() {
        System.out.println("bean7 doSomething was initiated ");
        bean7.doSomething();
        bean11.doSomethingElse();
    }

}

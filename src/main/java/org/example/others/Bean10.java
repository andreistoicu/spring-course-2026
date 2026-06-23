package org.example.others;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;

@Service
//field injection
public class Bean10 {

    @Autowired
    //field injection
    private Bean7 bean7;

    public Bean10() {
        System.out.println("bean10 constructor");
    }

    @PostConstruct
    void doSomethingElse() {
        System.out.println("doSomething bean10 was initiated ");
        bean7.doSomething();
    }

}

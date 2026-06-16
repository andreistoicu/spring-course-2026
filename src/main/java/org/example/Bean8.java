package org.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;

@Service
//Constructor injection
public class Bean8 {

    private final Bean7 bean7;

    // @Autowired - nu este obligatoriu, dar de preferat pentru a fi vizibil
    @Autowired
    //Constructor injection
    public Bean8(Bean7 bean7) {
        this.bean7 = bean7;
        System.out.println("bean8 constructor");
    }

    @PostConstruct
    void init(){
        System.out.println("Bean8 init() bean7 doSomething was initiated");
        bean7.doSomething();
    }

}

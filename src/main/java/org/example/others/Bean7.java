package org.example.others;

import org.springframework.stereotype.Service;

@Service
public class Bean7 {
    public Bean7() {
        System.out.println("bean7 constructor");
    }

    void doSomething() {
        System.out.println("doSomething was initiated ");
    }
}

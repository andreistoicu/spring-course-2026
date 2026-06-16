package org.example;

import org.springframework.stereotype.Component;

@Component //@Service @Controller @Repository
public class Bean1 {

    public Bean1(){
        System.out.println("Bean1");
    }
}

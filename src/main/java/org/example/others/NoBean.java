package org.example.others;

//@Service
public class NoBean {

    public NoBean() {
        System.out.println("noBean constructor");
    }

    void  doSomethingElse() {
        System.out.println("doSomethingElse was initiated from NoBean");
    }

}

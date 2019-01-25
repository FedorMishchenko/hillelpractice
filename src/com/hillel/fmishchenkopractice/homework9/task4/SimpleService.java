package com.hillel.fmishchenkopractice.homework9.task4;

@Service(name = "Simple service demo")
public class SimpleService {
    @Init
    public void initService(){
        System.out.println("Init service");
    }
    public void noAnnotationsMethod(){
        System.out.println("No annotations in SimpleService.method");
    }
}

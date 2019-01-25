package com.hillel.fmishchenkopractice.homework9.task4;

@Service(name = "Lazy service demo")
public class LazyService {
    @Init
    public void lazyInit(){
        System.out.println("Lazy init");
    }
    public void noAnnotationsMethod(){
        System.out.println("No annotations in LazyLoad.method");
    }
}

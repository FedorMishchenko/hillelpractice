package com.hillel.fmishchenkopractice.homework9.task3;

@Service(name = "TransactionService")
public class TransactionService {
    @Init
    public void lazyInit()
    {
        System.out.println("Lazy init");
    }
    public void noAnnotationsMethod(){

        System.out.println("No annotations in LazyLoad.method");
    }
}

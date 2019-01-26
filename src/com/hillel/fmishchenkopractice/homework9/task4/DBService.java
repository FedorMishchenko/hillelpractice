package com.hillel.fmishchenkopractice.homework9.task4;

public class DBService {

    public void create(int randomint){
        if(randomint >= 0 && randomint <= 5)
        System.out.println("create");
        else throw new RuntimeException();
    }
    public void find(int randomint){
        if(randomint >= 0 && randomint <= 5)
        System.out.println("find");
        else throw new RuntimeException();

    }
    public void update(int randomint){
        if(randomint >= 0 && randomint <= 5)
        System.out.println("update");
        else throw new RuntimeException();
    }
    public void delete(int randomint){
        if(randomint >= 0 && randomint <= 5)
        System.out.println("delete");
        else throw new RuntimeException();
    }
}

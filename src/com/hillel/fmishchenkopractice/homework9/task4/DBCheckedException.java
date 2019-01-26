package com.hillel.fmishchenkopractice.homework9.task4;

public class DBCheckedException extends IllegalArgumentException {
    public void getMassege(int massege){
        System.out.println("Illegal argument: " + massege);
    }
}

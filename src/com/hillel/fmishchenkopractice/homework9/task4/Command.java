package com.hillel.fmishchenkopractice.homework9.task4;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface Command{
    String args();
    String create();
    String read();
    String update();
    String delete();
    String print();
    int minArgs()default 0;
    boolean flag()default true;

}


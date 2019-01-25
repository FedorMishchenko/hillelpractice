package com.hillel.fmishchenkopractice.homework9.task3;

import java.lang.annotation.*;

@Documented
@Inherited
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface Init{
    boolean suppressException()default false;
}

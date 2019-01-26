package com.hillel.fmishchenkopractice.homework9.task3;

import java.lang.annotation.*;

@Documented
@Inherited
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
public @interface Service {
    String name();
    boolean lazyLoad() default false;
}


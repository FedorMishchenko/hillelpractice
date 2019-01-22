package com.hillel.fmishchenkopractice.homework9.task3;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

public class AnnotationAnalizer {
    @Target(value=ElementType.METHOD)
    @Retention(value= RetentionPolicy.RUNTIME)
    public @interface StartMethod {
    }

    @Target(value=ElementType.TYPE)
    @Retention(value= RetentionPolicy.RUNTIME)
    public @interface ControlledClass {
        String name();
    }


}

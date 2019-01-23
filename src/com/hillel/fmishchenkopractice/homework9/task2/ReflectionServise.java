package com.hillel.fmishchenkopractice.homework9.task2;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

/**
 * реализация билдера через рефлексию
 */
public class ReflectionServise<T> {
    String className = "Person";
    Class<T> clazz;
    Constructor constructor;
    Method [] methods;
    {
        try {
            clazz = (Class<T>) Class.forName(className);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
    {
        try {
            constructor = clazz.getConstructor();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }
    }
    Class<T>[] params = constructor.getParameterTypes();
    {
        for (Class<?> param : params) {
            System.out.println(param.getName());
        }
    }
    {
        methods = clazz.getMethods();
        for (Method method: methods){
            String string = method.getName();
        }
    }

}

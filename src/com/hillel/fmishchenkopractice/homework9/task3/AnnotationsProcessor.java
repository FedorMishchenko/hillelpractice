package com.hillel.fmishchenkopractice.homework9.task3;

import java.lang.reflect.Method;

public class AnnotationsProcessor {
    public static String className =
            "com.hillel.fmishchenkopractice.homework9.task3.UserService";

    public static void main(String[] args) throws ClassNotFoundException,
            IllegalAccessException, InstantiationException {
        inspectService(className.getClass());
        Class<?> clazz = Class.forName(className);
        Object object = clazz.newInstance();
        Method[] methods = clazz.getMethods();
        initMethod(object, methods);
        initObj(object, methods);
    }

    private static void initObj(Object object, Method[] methods) {
        for (Method method : methods) {
            if (method.isAnnotationPresent(InitObject.class)) {
                try {
                    method.invoke(object);
                } catch (Exception e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }

    private static void initMethod(Object object, Method[] methods) {
        for (Method method : methods) {
            if (method.isAnnotationPresent(Init.class)) {
                try {
                    method.invoke(object);
                } catch (Exception e) {
                    Init ann = method.getAnnotation(Init.class);
                    if (ann.suppressException()) {
                        System.err.println(e.getMessage());
                    } else throw new RuntimeException(e);
                }
            }
        }
    }


    static void inspectService(Class<?> service) {
        if (service.isAnnotationPresent(Service.class)) {
            try {
                loadService(className);
            } catch (ClassNotFoundException | InstantiationException | IllegalAccessException e) {
                e.printStackTrace();
            }
        }
    }


    static Object loadService(String className) throws ClassNotFoundException,
            IllegalAccessException, InstantiationException {
        Object ob = null;
        Class<?> clazz = Class.forName(className);
        if (clazz.isAnnotationPresent(Service.class)) {
            ob = clazz.newInstance();
        }
        return ob;
    }
}

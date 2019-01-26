package com.hillel.fmishchenkopractice.homework9.task3;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;

public class AnnotationsProcessor {
    public static void main(String[] args) throws ClassNotFoundException,
            IllegalAccessException, InstantiationException {
        String className = "com.hillel.fmishchenkopractice.homework9.task3.UserService";
        inspectService(UserService.class);
        Class<?> clazz = Class.forName(className);
        Object object = clazz.newInstance();
        UserService test = (UserService) object;
        Method[] methods = clazz.getMethods();
        inspectServiceForMethod(methods, test);
        initMethod(object, methods);
        initObj(object, methods);
    }

    private static void initObj(Object object, Method[] methods) {
        for (Method method : methods) {
            if (method.isAnnotationPresent(InitObject.class)) {
                try {
                    method.invoke(object);
                } catch (Exception e) {
                    InitObject ann = method.getAnnotation(InitObject.class);
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
            Service annotation = service.getAnnotation(Service.class);
            //todo: если классов много можно выбрать какой стартовать
        }
    }

    static void inspectServiceForMethod(Method[] methods, Object o) {
        for (int i = 0; i < methods.length; i++) {
            Annotation[] ann = methods[i].getAnnotations();
        }
    }

/*    static Object loadService(String className) throws ClassNotFoundException,
            IllegalAccessException, InstantiationException {
        Object ob = null;
        Class<?> clazz = Class.forName(className);
        if (clazz.isAnnotationPresent(Service.class)) {
            ob = clazz.newInstance();
        }
        return ob;
    }*/
}

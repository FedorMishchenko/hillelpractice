package com.hillel.fmishchenkopractice.homework9.task4;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

public class AnnotationsProcessor {
    public static void main(String[] args) throws ClassNotFoundException,
            IllegalAccessException, InstantiationException {
        String className1 = "com.hillel.fmishchenkopractice.homework9.task4.SimpleService" ;
        String className2 = "com.hillel.fmishchenkopractice.homework9.task4.LazyService" ;
        inspectService(SimpleService.class);
        inspectService(LazyService.class);
        inspectService(String.class);

        Class<?> clazz1 = Class.forName(className1);
        Object object1 = clazz1.newInstance();
        SimpleService test1 = (SimpleService) object1;

        Class<?> clazz2 = Class.forName(className2);
        Object object2 = clazz2.newInstance();
        LazyService test2 = (LazyService) object2;
        Method[] methods1 = clazz1.getMethods();
        Method[] methods2 = clazz2.getMethods();


        System.out.println();
        inspectServiceForMethod(methods1, test1);
        System.out.println();
        inspectServiceForMethod(methods2, test2);

        Map<String,Object> map = new HashMap<>();
        map.put(className1,loadService(className1));
        map.put(className2,loadService(className2));

    }

    static void inspectService(Class<?> service) {
        if (service.isAnnotationPresent(Service.class)) {
            Service annotation = service.getAnnotation(Service.class);
            System.out.println(annotation.name());
        } else System.out.println("Annotation not found");
    }

    static void inspectServiceForMethod(Method[] methods, Object o) {
        for (int i = 0; i < methods.length; i++) {
            Annotation[] ann = methods[i].getAnnotations();
            if (ann.length > 0) {
                for (int j = 0; j < ann.length; j++) {
                    System.out.println("Annotation: " + ann[j].toString() +
                            '\n' + "Class: " + o.getClass().getName());
                }
            }
        }
    }

    static Object loadService(String className) throws ClassNotFoundException,
            IllegalAccessException, InstantiationException {
        Object ob = null;
        Class<?> clazz = Class.forName(className);
        if(clazz.isAnnotationPresent(Service.class)){
            ob =  clazz.newInstance();
        }return ob;
    }
}

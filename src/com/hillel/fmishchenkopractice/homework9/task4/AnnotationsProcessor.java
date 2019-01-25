package com.hillel.fmishchenkopractice.homework9.task4;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;

public class AnnotationsProcessor {
    public static void main(String[] args) throws ClassNotFoundException,
            IllegalAccessException, InstantiationException
    {
        inspectService(SimpleService.class);
        inspectService(LazyService.class);
        inspectService(String.class);

        Class<?> clazz1 = Class.forName("com.hillel.fmishchenkopractice.homework9.task4.SimpleService");
        Object object1 = clazz1.newInstance();
        SimpleService test1 = (SimpleService) object1;


        Class<?> clazz2 = Class.forName("com.hillel.fmishchenkopractice.homework9.task4.LazyService");
        Object object2 = clazz2.newInstance();
        LazyService test2 = (LazyService) object2;

        Method[] methods1 = clazz1.getMethods();
        Method[] methods2 = clazz2.getMethods();

        inspectServiceForMethod(methods1);
        inspectServiceForMethod(methods2);
    }
    static void inspectService(Class<?> service){
        if(service.isAnnotationPresent(Service.class)){
            Service annotation = service.getAnnotation(Service.class);
            System.out.println(annotation.name());
        }
        else System.out.println("Annotation not found");
    }
    static void inspectServiceForMethod(Method[] methods){
        for(int i = 0; i < methods.length; i++){
            Annotation[] ann = methods[i].getAnnotations();
            if(ann.length > 0) {
                for (int j = 0; j < ann.length; j++) {
                    System.out.println(ann[j]);
                }
            }else System.out.println("No method annotations");
        }
    }
}

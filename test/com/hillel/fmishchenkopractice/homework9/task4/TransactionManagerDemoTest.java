package com.hillel.fmishchenkopractice.homework9.task4;

import org.junit.Test;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;


public class TransactionManagerDemoTest {

    @Test
    public static void main(String[] args) {
         TransactionManager<UserService> manager = (service) -> {
             Method[] methods = UserService.class.getMethods();
             for (Method method : methods) {
                 if (method.isAnnotationPresent(Transactional.class)) {
                     try {
                         method.invoke(service);
                     } catch (IllegalAccessException | InvocationTargetException e){
                         /*NOP*/
                     }
                 }
             }
        };
        manager.process(new UserService());

    }
}
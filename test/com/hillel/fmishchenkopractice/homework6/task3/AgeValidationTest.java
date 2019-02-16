package com.hillel.fmishchenkopractice.homework6.task3;

import org.junit.Assert;
import org.junit.Test;

import java.io.IOException;

import static org.junit.Assert.*;

public class AgeValidationTest {

    @Test
    public void check() {
        Person person = new Person();
        person.setAge(30);
        Person expected;
        try {
            expected = (Person)AgeValidation.class.getMethod("check")
                    .invoke(person);
            assertTrue(expected.equals(new IllegalArgumentException()));
        }catch (Exception ignore){
            /*NOP*/
        }


    }
}
package com.hillel.fmishchenkopractice.homework5task3;

import org.junit.Test;

import static org.junit.Assert.*;

public class CarTest {

    @Test
    public void compareTo() {
        Car car1 = new Car("porshe");
        Car car2 = new Car("porshe");
        assertEquals(0,car1.compareTo(car2));
    }
}
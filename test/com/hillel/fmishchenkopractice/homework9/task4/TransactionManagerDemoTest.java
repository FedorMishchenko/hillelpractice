package com.hillel.fmishchenkopractice.homework9.task4;

import org.junit.Test;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import static org.junit.Assert.*;

public class TransactionManagerDemoTest {

    @Test
    public void init() {
        String[] args = new String[5];
        TransactionManagerDemo demo = new TransactionManagerDemo();
        demo.main(args);
    }
}
package exersices.java8.defaultInterfaceMethods;

import org.junit.Test;

import static org.junit.Assert.*;

public class DefaultInterfaceMethodsTest {

    @Test
    public void print() {
        System.out.println(new DefaultInterfaceMethods().calculate(10));
        System.out.println(new DefaultInterfaceMethods().multiply(5,5));
    }
}
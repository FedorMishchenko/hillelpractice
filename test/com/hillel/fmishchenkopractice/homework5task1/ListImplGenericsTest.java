package com.hillel.fmishchenkopractice.homework5task1;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class ListImplGenericsTest {

    @Test
    public void isEmpty() {
        ListImplGenerics list = new ListImplGenerics();
        list.size = 0;
        boolean var = list.isEmpty();
        assertEquals(true,var);
    }

    @Test
    public void addObject() {
        ListImplGenerics list = new ListImplGenerics();
        list.size = 0;
        Object ob = new Object();
        assertTrue(list.addObject(ob));

    }

    @Test
    public void getObjectByIndex() {  // TO DO переделать реализацию
        ListImplGenerics list = new ListImplGenerics();
        Object expected = new Object();
        list.addObject(expected);
        Object actual = list.getObjectByIndex(0);
        assertEquals(expected,actual);
    }


    @Test
    public void contains() {
        ListImplGenerics<Object> list = new ListImplGenerics<>();
        Object ob = new Object();
        list.addObject(ob);
        assertTrue(list.contains(ob));

    }

    @Test
    public void remove() {  //TO DO переделать реализацию
        ListImplGenerics list = new ListImplGenerics();
        Object ob = new Object();
        list.addObject(ob);
        assertTrue(list.remove(ob));

    }
}
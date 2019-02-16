package com.hillel.fmishchenkopractice.homework6.task2;

import com.hillel.fmishchenkopractice.homework6.task2.StackImpl;
import org.junit.Test;

import static org.junit.Assert.*;

public class StackImplTest<T> {

    StackImpl<T> list;

    @Test
    public void add() {
        list = new StackImpl<>();
        Integer value = 10;
        Integer value2 = 20;
        list.add((T) value);
        list.add((T)value2);
        assertEquals(value2,list.get());

    }


    @Test
    public void get() {
        list = new StackImpl<>();
        Integer value = 10;
        Integer value2 = 20;
        list.add((T)value);
        list.add((T)value2);
        System.out.println("set size before get() = " + list.size());
        T res;
        res = list.get();
        System.out.println("set size after get() = " + list.size());
        System.out.println(list);
        assertEquals(value2,res);
    }

    @Test
    public void remove() {
        list = new StackImpl<>();
        Integer value = 10;
        Integer value2 = 20;
        list.add((T)value);
        list.add((T)value2);
        System.out.println("set size before remove() = " + list.size());
        list.remove();
        System.out.println("set size after remove() = " + list.size());
        T res;
        res = list.get();
        assertEquals(value,res);
    }

    @Test
    public void clear() {
        list = new StackImpl<>();
        Integer value = 10;
        Integer value2 = 20;
        list.add((T)value);
        list.add((T)value2);
        System.out.println("set size before clear() = " + list.size());
        list.clear();
        assertEquals(0,list.currentSize);

    }

    @Test
    public void getStart() {
        list = new StackImpl<>();
        Integer value = 10;
        Integer value2 = 20;
        list.add((T)value);
        list.add((T)value2);
        assertEquals(value,list.getStart());
        assertEquals(2,list.size());
    }

    @Test
    public void getEnd() {
        list = new StackImpl<>();
        Integer value = 10;
        Integer value2 = 20;
        list.add((T)value);
        list.add((T)value2);
        assertEquals(value2,list.getEnd());
        assertEquals(2,list.size());
    }
}
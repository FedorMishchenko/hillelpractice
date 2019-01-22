package com.hillel.fmishchenkopractice.homework5.task2.part2;

import com.hillel.fmishchenkopractice.homework5.task2.part2.List;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ListTest {


    @Test
    public void pushFront() {
        List list = new List();
        String str1 =  "first";
        String str2 = "second";
        list.pushFront(str1);
        list.pushFront(str2);
        list.showList();

    }

    @Test
    public void pushBack() {
        List list = new List();
        String str1 =  "first";
        String str2 = "second";
        list.pushBack(str1);
        list.pushBack(str2);
        list.showList();
    }

    @Test
    public void showList() {
        List list = new List();
        String actual =  "example";
        list.pushFront(actual);
        String expected = "example";
        System.out.print("actual = ");
        list.showList();
        System.out.println("expected = " + expected);
    }

    @Test
    public void deleteList() {
        List list = new List();
        String str1 =  "first";
        String str2 = "second";
        list.pushBack(str1);
        list.pushBack(str2);
        list.deleteList();
        int expected = 0;
        assertEquals(List.getSize(),expected);
    }

    @Test
    public void popBack() {
        List list = new List();
        String str1 =  "first";
        String str2 = "second";
        list.pushBack(str1);
        list.pushBack(str2);
        String expected = str2;
        assertEquals(list.popBack(),expected);

    }
}
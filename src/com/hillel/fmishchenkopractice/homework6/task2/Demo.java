package com.hillel.fmishchenkopractice.homework6.task2;

public class Demo {
    public static void main(String[] args) {
        StackImpl<String> stack = new StackImpl<>();
        stack.add("First string put in stack");
        stack.add("Second string put in stack");
        System.out.println("stack.size = " + stack.size());
        String str = stack.get();
        System.out.println(str);
        System.out.println("items in stack = " + stack.count);
        System.out.println("stack.size = " + stack.size());
        String str1 = stack.get();
        System.out.println(str1);
        System.out.println("stack.size = " + stack.size());
        System.out.println("items in stack = " + stack.count);
        stack.remove();

    }
}

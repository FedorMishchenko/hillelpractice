package com.hillel.fmishchenkopractice.homework6task2;

public class Demo {
    public static void main(String[] args) {
        StackImpl<String> stack = new StackImpl<>();
        stack.add("qqqqqqqq");
        stack.add("hgjjjjh");
        System.out.println(stack.size());
        String str = stack.get();
        System.out.println(str);
        System.out.println(stack.count);
        System.out.println(stack.size());
        String str1 = stack.get();
        System.out.println(str1);
        System.out.println(stack.size());
        System.out.println(stack.count);
 /*       stack.remove();
        System.out.println(str);*/
    }
}

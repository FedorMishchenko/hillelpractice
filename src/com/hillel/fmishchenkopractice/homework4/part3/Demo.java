package com.hillel.fmishchenkopractice.homework4.part3;

public class Demo {
    public static void main(String[] args) {
        LinkedList<Integer> list = new LinkedList<>();
        list.add(10);
        System.out.println(list.isEmpty());
        System.out.println(list.get(0));
        list.add(20);
        list.add(40);
        list.add(30);
        System.out.println(list.contains(30));
        System.out.println("----------------------");
        for (int i = 0; i < list.getSize(); i++){
            System.out.println(list.get(i));
        }
        System.out.println("----------------------");
        list.remove(2);
        for (int i = 0; i < list.getSize(); i++){
            System.out.println(list.get(i));
        }
        System.out.println("----------------------");
        list.clear();
        System.out.println(list.isEmpty());
        System.out.println(list.getSize());
    }
}

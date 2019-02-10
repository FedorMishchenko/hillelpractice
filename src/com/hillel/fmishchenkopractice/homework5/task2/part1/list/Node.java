package com.hillel.fmishchenkopractice.homework5.task2.part1.list;

class Node {

    String data;
    ThreadLocal<Node> next;

    Node(String aStr) {

        data = aStr;
        next = null;
    }
}

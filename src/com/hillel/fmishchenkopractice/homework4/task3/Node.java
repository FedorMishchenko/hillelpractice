package com.hillel.fmishchenkopractice.homework4.task3;

public class Node<T> {

    public Node next;
    private Node previous;
    private T t;


    public Node() {
        this.next = null;
        this.previous = null;
    }

    public Node(Node previous) {
        this.next = null;
        this.previous = previous;
    }

    public Node getNext() {
        return next;
    }

    public void setNext(Node next) {
        this.next = next;
    }

    public Node getPrevious() {
        return previous;
    }

    private void setPrevious(Node previous) {
        this.previous = previous;
    }

    public T getT() {
        return t;
    }

    public void setT(T t) {
        this.t = t;
    }

    @Override
    public boolean equals(Object obj) {
        return t.equals(obj);
    }

    @Override
    public String toString() {
        return "Node{" + "next=" + next +
                ", previous=" + previous + ", t=" + t + '}';
    }
}

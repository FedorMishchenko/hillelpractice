package com.hillel.fmishchenkopractice.homework5.task1;

public class Node<T> {
    Node<T> next;
    Node<T> prev;
     T item;


    Node(Node<T> prev, T element, Node<T> next) {
        this.item = element;
        this.next = next;
        this.prev = prev;
    }


    public Node getNext() {
        return next;
    }

    public void setNext(Node next) {
        this.next = next;
    }

    public Node getPrevious() {
        return prev;
    }

    private void setPrevious(Node previous) {
        this.prev = previous;
    }

    public T getT() {
        return item;
    }

    public void setT(T t) {
        this.item = t;
    }

    @Override
    public boolean equals(Object obj) {
        return item.equals(obj);
    }

    @Override
    public String toString() {
        return "Node next = " + next +
                ", previous = " + prev + ", t = " + item;
    }
}

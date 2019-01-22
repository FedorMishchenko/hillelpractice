package com.hillel.fmishchenkopractice.homework4.task3;

import java.util.Collection;

public class MyListImpl<E> extends MyAbstractList {
    private Node<E> previous;
    private Node<E> next;
    private Node<E> first;

    transient Node<E> last;

    transient int size = 0;

    public MyListImpl() {

    }

    public MyListImpl(Collection<? extends E> collection) {
        this();
        addAll(collection);
    }
    @Override
    public int size() {
        return this.size;
    }
    @Override
    public boolean isEmpty() {
        if (size() == 0) {
            return true;
        } else return false;
    }

    public boolean addObject(E e) {
        final Node<E> l = last;
        final Node<E> newNode = new Node<E>();
        last = newNode;
        if (l == null)
            first = newNode;
        else
            l.next = newNode;
        size++;
        return true;
    }

    public Node<E> getObjectByIndex(int index) {
        Node<E> node = null;
        if (!isEmpty() && (index >= 0 && index < size)) {
            node = first;
            for (int i = 1; i <= index; i++) {
                node.getNext();
            }
        }
        return node;

    }

    public E getObject(int index) {
        E element;

        if (index >= 0 && index < size()) {
            element = getObjectByIndex(index).getT();
        } else throw new IndexOutOfBoundsException("Index out of bounds");
        return element;

    }
    @Override
    public boolean contains(Object object) {
        for (int i = 0; i < size(); i++) {
            if (get(i).equals(object)) return true;
        }
        return false;

    }

    public boolean remove(Object object) {
        Node<E> node = first;

        for (int i = 0; i < size(); i++) {
            if (node.equals(object)) {
                node.getPrevious().setNext(node.getNext());
                return true;
            }
        }
        return false;
    }

}

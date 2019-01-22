package com.hillel.fmishchenkopractice.homework5.task1;

import java.util.Collection;

public class ListImplGenerics<E> extends AbstractList<E> {

    private Node<E> last;

    private Node<E> first;

    transient int size = 0;

    public ListImplGenerics() {
    }

    public ListImplGenerics(Collection<? extends E> collection) {
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
        Node<E> f =  first;
        Node<E> newNode = new Node<E>(null, e, f);
        last = newNode;
        if (f == null)
            last = newNode;
        else
            f.prev = newNode;
        size++;
        return true;
    }

    public Node<E> getObjectByIndex(int index) {
        Node<E> node = null;
        if (!isEmpty() && (index >= 0 && index < size)) {
            node = first;
            for (int i = 1; i < index; i++) {
                node.getNext();
            }
        }
        return node;

    }


    @Override
    public boolean contains(Object object) {
        return indexOf(object) != -1;
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

package com.hillel.fmishchenkopractice.homework4.task1.part3;

import java.util.Iterator;

public class LinkedListRealization<T> implements Iterable<T> {
    private Node first;
    private Node last;
    private int size;

    private static class Node<T> {
        T element;
        Node next;
        Node previous;

        public Node(T element) {
            this.element = element;
        }

        public Node() {
        }
    }

    public LinkedListRealization() {
        this.first = null;
        this.last = null;
        this.size = 0;

    }
    public int getSize(){
        return size;
    }
    public void add(T item) {
        Node node = new Node(item);
        if (first == null) {
            node.next = null;
            node.previous = null;
            first = node;
            last = node;
        } else {
            last.next = node;
            node.previous = last;
            last = node;
        }
        size++;
    }

    public void add(int index, T item) {
        if (index < 0 || index >= size) {
            throw new IllegalArgumentException();
        }
        Node node = new Node(item);
        if (index == 0) {
            add(item);
        }
        if (index == size) {
            last.next = node;
            last = node;
        }
        Node oldNode = first;
        for (int i = 0; i < size; i++) {
            oldNode = oldNode.next;
        }
        Node oldPrevious = oldNode.previous;
        oldPrevious.next = node;
        oldPrevious.previous = node;

        node.previous = oldPrevious.previous;
        node.next = oldNode;
        size++;
    }

    public void clear() {
        first = null;
        last = null;
        size = 0;
    }

    public boolean contains(T item) {
        for (int i = 0; i < size; i++) {
            if ((get(i) == item))
                return true;
        }
        return false;
    }

    public T get(int index) {
        if (index < 0 || index >= size) {
            throw new IllegalArgumentException();
        }
        Node result = first;
        for (int i = 0; i < index; i++)
            result = result.next;
        return (T) result.element;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public boolean remove(int index) {
        if (index < 0 || index >= size) {
            throw new IllegalArgumentException();
        }
        if (index == 0) {
            first = first.next;
        } else {
            Node node = findNodePrevByIndex(index);
            Node tmp = findByIndex(index);
            node.next = tmp.next;
        }
        size--;
        return true; //todo: test method
    }

    public boolean removeElement(Node element) {
        if (size == 0) {
            return false;
        } else if (size == 1) {
            first = null;
            last = null;
            size = 0;
            return true;
        }
        Node nodePrev = findNodePrev(element);
        if (nodePrev.element == null) {
            first = first.next;
            size--;
            return true;
        } else if (nodePrev != null) {
            if (last.element == element) {
                nodePrev.next = null;
                last = nodePrev;
            } else {
                nodePrev.next = nodePrev.next.next;
            }
            size--;
            return true;
        }
        return false;
    }

    private Node findNodePrev(Node element) {
        if (first.element == element) {
            return new Node();
        }
        Node node = first;
        while (node.next != null) {
            if (node.next.element == element) {
                return node;
            }
            node = node.next;
        }
        return null;
    }

    private Node findByIndex(int index) {
        if (index < 0 || index > size - 1) {
            throw new IndexOutOfBoundsException();
        }
        int tmpIndex = 0;
        if (first == null) {
            throw new IndexOutOfBoundsException();
        }
        if (index == 0) {
            return first;
        }
        Node node = first;
        while (node.next != null) {
            node = node.next;
            tmpIndex++;
            if (tmpIndex == index) {
                return node;
            }
        }
        throw new IndexOutOfBoundsException();
    }

    private Node findNodePrevByIndex(int index) {
        if (index <= 0 || index > size - 1) {
            return null;
        }
        int count = 0;
        Node node = first;
        while (node.next != null) {
            if (count == index - 1) {
                return node;
            }
            count++;
            node = node.next;
        }
        return null;
    }

    @Override
    public Iterator<T> iterator() {
        throw new UnsupportedOperationException();
    }

}

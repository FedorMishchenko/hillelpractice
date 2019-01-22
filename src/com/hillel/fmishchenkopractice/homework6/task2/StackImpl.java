package com.hillel.fmishchenkopractice.homework6.task2;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.function.Consumer;

public class StackImpl<T> implements Stack<T>, Iterable<T> {

    LinkedList<T> list = new LinkedList<>();
    int count = 0;
    int currentSize = list.size();


    @Override
    public void add(T value) {
        list.addLast(value);
        count++;
    }

    @Override
    public void set() {

    }

    @Override
    public T get() {
        if (this.count == 0)
        try {
            throw new InvalidOperationException();
        } catch (InvalidOperationException e){
            System.out.println("Stack is empty");
        }
        T result = list.getLast();
        list.removeLast();
        count--;
        return result;
    }

    @Override
    public void remove() {
        if(count == 0){
            try {
                throw new InvalidOperationException();
            } catch (InvalidOperationException e) {
                System.out.println("Stack is empty");
            }
        }
        else list.removeLast();
        count--;



    }

    @Override
    public void clear() {
        if (this.count == 0)
            try {
                throw new InvalidOperationException();
            } catch (InvalidOperationException e){
                System.out.println("Stack is empty");
            }
            list.clear();
            count = 0;

    }

    @Override
    public int size() {
        return list.size();
    }

    @Override
    public T getStart() {
        if (this.count == 0)
            try {
                throw new InvalidOperationException();
            } catch (InvalidOperationException e){
                System.out.println("Stack is empty");
            }
        return list.getFirst();
    }

    @Override
    public T getEnd() {
        if (this.count == 0)
            try {
                throw new InvalidOperationException();
            } catch (InvalidOperationException e){
                System.err.println("Stack is empty");
            }
        return list.getLast();

    }

    @Override
    public Iterator<T> iterator() {
        Iterator<T> it = new Iterator<T>() {

            private int currentIndex = 0;

            @Override
            public boolean hasNext() {
                return currentIndex < currentSize && list.get(currentIndex) != null;
            }

            @Override
            public T next() {
                return list.get(currentIndex++);
            }

            @Override
            public void remove() {
                throw new UnsupportedOperationException();
            }
        };
        return it;
    }


    @Override
    public void forEach(Consumer<? super T> action) {

    }
}

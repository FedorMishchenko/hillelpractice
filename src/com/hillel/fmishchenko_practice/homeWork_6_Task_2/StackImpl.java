package com.hillel.fmishchenko_practice.homeWork_6_Task_2;

import java.util.LinkedList;

public class StackImpl<T> implements Stack<T> {

    LinkedList<T> list = new LinkedList<>();
    int count = 0;


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
            System.err.println("Stack is empty");
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
                System.err.println("Stack is empty");
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
                System.err.println("Stack is empty");
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
                System.err.println("Stack is empty");
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
}

package com.hillel.fmishchenkopractice.homework6.task1;


import java.util.Arrays;
import java.util.Iterator;

public class List<T> implements Iterable<T> {

    public T[] arrayList;
    private int currentSize;

    @Override
    public String toString() {
        return "List{" +
                "arrayList=" + Arrays.toString(arrayList) +
                ", currentSize=" + currentSize +
                '}';
    }

    public List(T[] newArray) {
        this.arrayList = newArray;
        this.currentSize = arrayList.length;
    }

    public List() {

    }

    @Override
    public Iterator<T> iterator() {
        Iterator<T> it = new Iterator<T>() {

            private int currentIndex = 0;

            @Override
            public boolean hasNext() {
                return currentIndex < currentSize && arrayList[currentIndex] != null;
            }

            @Override
            public T next() {
                return arrayList[currentIndex++];
            }

            @Override
            public void remove() {
                throw new UnsupportedOperationException();
            }
        };
        return it;
    }
}

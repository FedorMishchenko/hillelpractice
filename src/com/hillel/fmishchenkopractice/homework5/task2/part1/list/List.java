package com.hillel.fmishchenkopractice.homework5.task2.part1.list;


import java.util.Objects;

public class List {

    private Node head;
    private static int size = 0;

    List() {
        head = null;
    }

    public static int getSize() {
        return size;
    }

    public void pushFront(String string) {

         Node temp = new Node(string);

        if (head == null)
            head = temp;
        else {
            temp.next.set(head);
            head = temp;
        }

        ++size;
    }

    void pushBack(String string) {

        Node temp = new Node(string);

        if (head == null)
            head = temp;
        else {
            Node aTemp = head;

            while (aTemp.next.get() != null)
                aTemp = aTemp.next.get();

            aTemp.next.set(temp);
        }

        ++size;
    }

    void showList() {

        if (head != null) {
            Node temp = head;

            while (temp != null) {
                System.out.println(temp.data);
                temp = temp.next.get();
            }
        } else
            System.out.println("Список пуст!");
    }

    public void deleteList() {

        while (head != null) {

            Node temp = head;

            while (temp.next.get() != null) {
                temp = temp.next.get();
            }

            if (head.next.get() == null) {
                head = null;}
            else{
                    Objects.requireNonNull(temp).next = null;
                }
            }

            size = 0;
        }


       public String popBack (){

            if (head != null) {

                String value;

                if (head.next.get() == null) {

                    value = head.data;
                    head = null;
                    size = 0;
                    return value;
                } else {
                    Node temp = head, _temp = null;

                    while (temp.next.get() != null) {
                        _temp = temp;
                        temp = temp.next.get();
                    }

                    value = temp.data;
                    temp = _temp;
                    temp.next = null;

                    --size;
                    return value;
                }
            } else
                return "Список пуст!";
        }
    }
package com.hillel.fmishchenkopractice.homework5.task2.part2;

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
            temp.next = head;
            head = temp;
        }

        ++size;
    }

    public void pushBack(String string) {

        Node temp = new Node(string);

        if (head == null)
            head = temp;
        else {
            Node aTemp = head;

            while (aTemp.next != null)
                aTemp = aTemp.next;

            aTemp.next = temp;
        }

        ++size;
    }

    public void showList() {

        if (head != null) {
            Node temp = head;

            while (temp != null) {
                System.out.println(temp.data);
                temp = temp.next;
            }
        } else
            System.out.println("Список пуст!");
    }

    public void deleteList() {

        while (head != null) {

            Node temp = head, _temp = null;

            while (temp.next != null) {
                _temp = temp;
                temp = temp.next;
            }

            if (head.next == null) {
                head = null;}
            else{
                    temp = _temp;
                    temp.next = null;
                }
            }

            size = 0;
        }


       public String popBack (){

            if (head != null) {

                String value = "";

                if (head.next == null) {

                    value = head.data;
                    head = null;
                    size = 0;
                    return value;
                } else {
                    Node temp = head, _temp = null;

                    while (temp.next != null) {
                        _temp = temp;
                        temp = temp.next;
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
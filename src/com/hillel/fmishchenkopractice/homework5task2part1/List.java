package com.hillel.fmishchenkopractice.homework5task2part1;
public class List {

    private Node Head;
    private static int size = 0;

    List() {
        Head = null;
    }

    static int getSize() {
        return size;
    }

    void pushFront(String string) {

        Node temp = new Node(string);

        if (Head == null)
            Head = temp;
        else {
            temp.next = Head;
            Head = temp;
        }

        ++size;
    }

    void pushBack(String string) {

        Node temp = new Node(string);

        if (Head == null)
            Head = temp;
        else {
            Node aTemp = Head;

            while (aTemp.next != null)
                aTemp = aTemp.next;

            aTemp.next = temp;
        }

        ++size;
    }

    void showList() {

        if (Head != null) {
            Node temp = Head;

            while (temp != null) {
                System.out.println(temp.data);
                temp = temp.next;
            }
        } else
            System.out.println("Список пуст!");
    }

    void deleteList() {

        while (Head != null) {

            Node temp = Head, _temp = null;

            while (temp.next != null) {
                _temp = temp;
                temp = temp.next;
            }

            if (Head.next == null) {
                Head = null;}
            else{
                    temp = _temp;
                    temp.next = null;
                }
            }

            size = 0;
        }


        String popBack (){

            if (Head != null) {

                String value = "";

                if (Head.next == null) {

                    value = Head.data;
                    Head = null;
                    size = 0;
                    return value;
                } else {
                    Node temp = Head, _temp = null;

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
package com.hillel.fmishchenko_practice.HomeWork_3_Task_1.Edition;

public class EditionMain {

    public static void main(String[] args) {
        Edition edition = new Directory();
        ((Directory) edition).setName("Справочник");
        ((Directory) edition).setAuthor("Иванов И.И.");

        Book book = new Encyclopedia();
        book.setName("Энциклопедия");
        book.setAuthor("Петров.");

        edition.print();
        book.print();

        Book book2 = new Directory();
        book2.setName("Энциклопедический словарь");
        book2.setAuthor("Сидоров.");
        Edition edition2 = new Adapter(book2);
        edition2.print();

    }
}

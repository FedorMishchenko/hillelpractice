package com.hillel.fmishchenkopractice.homework3.Edition;

public class EditionMain {

    public static void main(String[] args) {
        Directory edition = new Directory();
        edition.setName("Справочник");
        edition.setAuthor("Иванов И.И.");

        Book book = new Encyclopedia();
        book.setName("Энциклопедия");
        book.setAuthor("Петров.");

        Book book2 = new Directory();
        book2.setName("Энциклопедический словарь");
        book2.setAuthor("Сидоров.");
        Edition edition2 = new Adapter(book2);
        edition.print();
        book.print();
        edition2.print();

    }
}

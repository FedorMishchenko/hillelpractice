package com.hillel.fmishchenkopractice.homework3.Edition;

abstract class Book implements Edition{
    private int strings;
    private int price;
    private String name;
    private String author;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getStrings() {
        return strings;
    }

    public void setStrings(int strings) {
        this.strings = strings;
    }

    public String getAuthor() {
        return author;
    }

    void setAuthor(String author) {
        this.author = author;
    }

    @Override
    public void print() {
           System.out.println("book name = " + name + '\n' + "book author = " + author + '\n');
    }


}

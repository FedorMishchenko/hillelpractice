package com.hillel.fmishchenkopractice.homework2.homeWork_2_Gift;

abstract class Chocolate {
    private String name;
    private int sugar;
    private int weight;
    private int price;


    public int getSugar() {
        return sugar;
    }

    public void setSugar(int sugar) {
        this.sugar = sugar;
    }


    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean equals(Chocolate c){
        if(this.name == c.name)return true;
        else return false;
    }
    public int hashcode(){
        return this.hashCode();
    }


}

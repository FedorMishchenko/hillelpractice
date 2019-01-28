package com.hillel.fmishchenkopractice.homework2.flowers;

public class Demo {
    public static void main(String[] args) {
        FlowerFactory factory = Flower::new;
        Flower aster = factory.create("aster",
                "red",5,50);
        Flower rose = factory.create("rose",
                "yellow",2,70);
        Flower chamomile = factory.create("chamomile",
                "white",1,15);
        FlowerUtils utils = new FlowerUtils();
        utils.add("aster",aster);
        utils.add("rose",rose);
        utils.add("chamomile",chamomile);
        utils.bouquet.forEach((k,v) -> System.out.println(
                "Name = " + k + " " + v.toString()));
    }
}

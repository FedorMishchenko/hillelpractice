package com.hillel.fmishchenkopractice.homework2.homework2Auto;

public class TestAuto {
    public static void main(String[] args) {
        Auto hatch = new AutoHatch("Audi");
        hatch.setColor("silver");
        System.out.println("Model auto: " + hatch.getModel() + ", color: " + hatch.getColor());
    }
}

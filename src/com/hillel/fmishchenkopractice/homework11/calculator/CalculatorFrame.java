package com.hillel.fmishchenkopractice.homework11.calculator;

import javax.swing.*;

class CalculatorFrame extends JFrame {
    public CalculatorFrame() {
        setTitle("Calculator");
        CalculatorPanel panel = new CalculatorPanel();
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
        add(panel);
        pack();
    }
}

package com.hillel.fmishchenkopractice.homework11.calculator;

import javax.swing.*;
import java.awt.*;

public class Calculator {
    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
                CalculatorFrame frame = new CalculatorFrame();
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.setVisible(true);
        });
    }
}

package com.hillel.fmishchenkopractice.homework11.calculator;

import com.hillel.fmishchenkopractice.homework11.interfaces.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.*;


public class CalculatorPanel extends JPanel {
    private JButton display;
    private JPanel panel;
    private double result;
    private String lastCommand;
    private boolean start;
    public CalculatorPanel() {
        setLayout(new BorderLayout());

        result = 0;
        lastCommand = "=";
        start = true;

        display = new JButton(" ");
        display.setEnabled(false);
        add(display, BorderLayout.NORTH);

        ActionListener insert = new InsertAction();
        ActionListener command = new CommandAction();

        panel = new JPanel();
        Dimension dimension = new Dimension();
        dimension.width = 300;
        dimension.height = 200;
        panel.setPreferredSize(dimension);
        panel.setLayout(new GridLayout(4, 5));
        addButtons(insert, command);

        add(panel, BorderLayout.CENTER);
    }

    public void addButtons(ActionListener insert, ActionListener command) {
        add(command, "C");
        add(insert, "7");
        add(insert, "8");
        add(insert, "9");
        add(command, "/");

        add(command, "%");
        add(insert, "4");
        add(insert, "5");
        add(insert, "6");
        add(command, "*");

        add(command, "x2");
        add(insert, "1");
        add(insert, "2");
        add(insert, "3");
        add(command, "-");

        add(command, "Sqr");
        add(insert, "0");
        add(insert, ".");
        add(command, "=");
        add(command, "+");
    }

    public void add(ActionListener command, String s) {
        addButton(s, command);
    }

    private void addButton(String label, ActionListener listener) {
        JButton button = new JButton(label);
        button.addActionListener(listener);
        panel.add(button);
    }

    public class InsertAction implements ActionListener {
        public void actionPerformed(ActionEvent event) {
            String input = event.getActionCommand();
            if (start) {
                display.setText("");
                start = false;
            }
            display.setText(display.getText() + input);
        }
    }

    public class CommandAction implements ActionListener {
        public void actionPerformed(ActionEvent event) {
            String command = event.getActionCommand();
            if (start) {
                if (command.equals("C")) {
                    display.setText(" ");
                    start = false;
                } else lastCommand = command;
            } else {
                calculate(Double.parseDouble(display.getText()));
                lastCommand = command;
                start = true;
            }
        }
    }

    public void calculate(double arg) {//todo: refactoring

        switch (lastCommand) {
            case "+":
                Addition add = (x, y) -> x + y;
                result = add.add(result,arg);
                break;
            case "-":
                Subtraction sub = (x, y) -> x - y;
                result = sub.subtract(result,arg);
                break;
            case "*":
                Multiplication mult = (x, y) -> x * y;
                result = mult.multiply(result,arg);
                break;
            case "/":
                Division div = (x, y) -> x / y;
                result = div.divide(result,arg);
                break;
            case "=":
                result = arg;
                break;
            case "Sqr":
                SquareRoot sqr = (x) -> Math.sqrt(x);

                result = sqr.sqrt(arg);
            case "%":
                Module mod = (x, y) -> x % y;
                result = mod.module(result, arg);
            case "x2":
                Exponentiation exp = (x) -> x * x;
                result = exp.exponent(arg);

        }
        display.setText(String.valueOf(result));
    }

}
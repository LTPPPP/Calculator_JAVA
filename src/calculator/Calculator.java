package calculator;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Calculator extends JFrame implements ActionListener {
    private JTextField textField;
    private JButton[] numberButtons = new JButton[10];
    private JButton[] functionButtons = new JButton[13];
    private JButton addButton, subButton, mulButton, divButton;
    private JButton decButton, equButton, delButton, clrButton;
    private JButton sqrtButton, cbrtButton, sinButton, cosButton;
    private JButton equationButton;
    private JPanel panel;

    public Calculator() {
        textField = new JTextField();
        textField.setBounds(50, 25, 300, 50);
        textField.setEditable(false);

        addButton = new JButton("+");
        subButton = new JButton("-");
        mulButton = new JButton("*");
        divButton = new JButton("/");
        decButton = new JButton(".");
        equButton = new JButton("=");
        delButton = new JButton("Delete");
        clrButton = new JButton("Clear");
        sqrtButton = new JButton("√");
        cbrtButton = new JButton("∛");
        sinButton = new JButton("sin");
        cosButton = new JButton("cos");
        equationButton = new JButton("Equation");

        functionButtons[0] = addButton;
        functionButtons[1] = subButton;
        functionButtons[2] = mulButton;
        functionButtons[3] = divButton;
        functionButtons[4] = decButton;
        functionButtons[5] = equButton;
        functionButtons[6] = delButton;
        functionButtons[7] = clrButton;
        functionButtons[8] = sqrtButton;
        functionButtons[9] = cbrtButton;
        functionButtons[10] = sinButton;
        functionButtons[11] = cosButton;
        functionButtons[12] = equationButton;

        for (int i = 0; i < 13; i++) {
            functionButtons[i].addActionListener(this);
            functionButtons[i].setFocusable(false);
        }

        for (int i = 0; i < 10; i++) {
            numberButtons[i] = new JButton(String.valueOf(i));
            numberButtons[i].addActionListener(this);
            numberButtons[i].setFocusable(false);
        }

        panel = new JPanel();
        panel.setBounds(50, 100, 300, 300);
        panel.setLayout(new GridLayout(5, 4, 10, 10));

        panel.add(numberButtons[1]);
        panel.add(numberButtons[2]);
        panel.add(numberButtons[3]);
        panel.add(addButton);
        panel.add(numberButtons[4]);
        panel.add(numberButtons[5]);
        panel.add(numberButtons[6]);
        panel.add(subButton);
        panel.add(numberButtons[7]);
        panel.add(numberButtons[8]);
        panel.add(numberButtons[9]);
        panel.add(mulButton);
        panel.add(decButton);
        panel.add(numberButtons[0]);
        panel.add(equButton);
        panel.add(divButton);
        panel.add(sqrtButton);
        panel.add(sinButton);
        panel.add(cosButton);
        panel.add(equationButton);

        this.setLayout(null);
        this.add(textField);
        this.add(panel);
        this.add(delButton);
        this.add(clrButton);

        delButton.setBounds(50, 430, 100, 50);
        clrButton.setBounds(170, 430, 100, 50);

        this.setSize(400, 550);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        for (int i = 0; i < 10; i++) {
            if (e.getSource() == numberButtons[i]) {
                textField.setText(textField.getText().concat(String.valueOf(i)));
            }
        }
        if (e.getSource() == decButton) {
            textField.setText(textField.getText().concat("."));
        }
        if (e.getSource() == addButton) {
            textField.setText(textField.getText().concat(" + "));
        }
        if (e.getSource() == subButton) {
            textField.setText(textField.getText().concat(" - "));
        }
        if (e.getSource() == mulButton) {
            textField.setText(textField.getText().concat(" * "));
        }
        if (e.getSource() == divButton) {
            textField.setText(textField.getText().concat(" / "));
        }
        if (e.getSource() == equButton) {
            try {
                String expression = textField.getText();
                String[] parts = expression.split(" ");
                double num1 = Double.parseDouble(parts[0]);
                char operator = parts[1].charAt(0);
                double num2 = Double.parseDouble(parts[2]);
                double result = 0;

                switch (operator) {
                    case '+':
                        result = num1 + num2;
                        break;
                    case '-':
                        result = num1 - num2;
                        break;
                    case '*':
                        result = num1 * num2;
                        break;
                    case '/':
                        result = num1 / num2;
                        break;
                }

                textField.setText(String.valueOf(result));
            } catch (Exception ex) {
                textField.setText("Error");
            }
        }
        if (e.getSource() == clrButton) {
            textField.setText("");
        }
        if (e.getSource() == delButton) {
            String str = textField.getText();
            textField.setText("");
            for (int i = 0; i < str.length() - 1; i++) {
                textField.setText(textField.getText() + str.charAt(i));
            }
        }
        if (e.getSource() == sqrtButton) {
            try {
                double number = Double.parseDouble(textField.getText());
                textField.setText(String.valueOf(Roots.sqrt(number)));
            } catch (Exception ex) {
                textField.setText("Error");
            }
        }
        if (e.getSource() == sinButton) {
            try {
                double angle = Double.parseDouble(textField.getText());
                textField.setText(String.valueOf(Trigonometry.sin(angle)));
            } catch (Exception ex) {
                textField.setText("Error");
            }
        }
        if (e.getSource() == cosButton) {
            try {
                double angle = Double.parseDouble(textField.getText());
                textField.setText(String.valueOf(Trigonometry.cos(angle)));
            } catch (Exception ex) {
                textField.setText("Error");
            }
        }
        if (e.getSource() == equationButton) {
            new QuadraticEquationSolver();
        }
    }

    public static void main(String[] args) {
        new Calculator();
    }
}

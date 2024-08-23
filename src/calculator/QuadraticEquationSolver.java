package calculator;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class QuadraticEquationSolver extends JFrame implements ActionListener {
    private JTextField aField, bField, cField;
    private JButton solveButton;
    private JLabel resultLabel;

    public QuadraticEquationSolver() {
        setTitle("Quadratic Equation Solver");
        setSize(300, 200);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLayout(new GridLayout(4, 2));

        aField = new JTextField();
        bField = new JTextField();
        cField = new JTextField();
        solveButton = new JButton("Solve");
        resultLabel = new JLabel("Result: ");

        solveButton.addActionListener(this);

        add(new JLabel("a = "));
        add(aField);
        add(new JLabel("b = "));
        add(bField);
        add(new JLabel("c = "));
        add(cField);
        add(solveButton);
        add(resultLabel);

        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == solveButton) {
            try {
                double a = Double.parseDouble(aField.getText());
                double b = Double.parseDouble(bField.getText());
                double c = Double.parseDouble(cField.getText());

                double[] roots = QuadraticEquation.solve(a, b, c);
                if (roots.length == 2) {
                    resultLabel.setText("Roots: " + roots[0] + ", " + roots[1]);
                } else if (roots.length == 1) {
                    resultLabel.setText("Root: " + roots[0]);
                } else {
                    resultLabel.setText("No real roots");
                }
            } catch (Exception ex) {
                resultLabel.setText("Error");
            }
        }
    }
}

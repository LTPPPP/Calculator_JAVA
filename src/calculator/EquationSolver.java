package calculator;

public class EquationSolver {
    public static double solveLinearEquation(double a, double b) {
        if (a == 0) {
            throw new ArithmeticException("Division by zero");
        }
        return -b / a;
    }
}

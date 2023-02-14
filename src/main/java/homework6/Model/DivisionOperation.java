package homework6.Model;

public class DivisionOperation extends CalculatorOperation {
    public double performOperation(double number1, double number2) {
        if (number2 == 0) {
            throw new ArithmeticException("Cannot divide by zero");
        }
        return number1 / number2;
    }
}
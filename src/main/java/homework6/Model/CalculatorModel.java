package homework6.Model;

public class CalculatorModel {
    private double number1;
    private double number2;
    private CalculatorOperation operation;

    public void setNumber1(double number1) {
        this.number1 = number1;
    }

    public void setNumber2(double number2) {
        this.number2 = number2;
    }

    public void setOperation(String operation) {
        switch (operation) {
            case "+" -> this.operation = new AdditionOperation();
            case "-" -> this.operation = new SubtractionOperation();
            case "*" -> this.operation = new MultiplicationOperation();
            case "/" -> this.operation = new DivisionOperation();
            default -> throw new IllegalArgumentException("Unsupported operation: " + operation);
        }
    }

    public double calculate() {
        if (operation == null) {
            throw new IllegalStateException("Operation not set");
        }

        return operation.performOperation(number1, number2);
    }
}
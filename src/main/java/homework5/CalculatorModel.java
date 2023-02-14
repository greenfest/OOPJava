package homework5;

public class CalculatorModel {
    private int number1;
    private int number2;
    private int result;

    public void add() {
        result = number1 + number2;
    }

    public void subtract() {
        result = number1 - number2;
    }

    public void multiply() {
        result = number1 * number2;
    }

    public void divide() {
        if (number2 == 0) {
            throw new IllegalArgumentException("Cannot divide by zero");
        }
        result = number1 / number2;
    }

    public int getResult() {
        return result;
    }

    public void setNumber1(int number1) {
        this.number1 = number1;
    }

    public void setNumber2(int number2) {
        this.number2 = number2;
    }
}
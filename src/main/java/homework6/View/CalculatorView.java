package homework6.View;


public class CalculatorView {
    private final UserInput input;
    private final UserOutput output;

    public CalculatorView(UserInput input, UserOutput output) {
        this.input = input;
        this.output = output;
    }

    public double getNumber1() {
        return input.readNumber("number 1");
    }

    public double getNumber2() {
        return input.readNumber("number 2");
    }

    public String getOperation() {
        return input.readOperation();
    }

    public void showResult(double result) {
        output.displayResult(result);
    }
}
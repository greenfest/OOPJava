package homework5;

public class CalculatorController {
    private final CalculatorModel model;
    private final CalculatorView view;

    public CalculatorController(CalculatorModel model, CalculatorView view) {
        this.model = model;
        this.view = view;
    }

    public void run() {
        while (true) {
            int number1 = view.getNumber1();
            int number2 = view.getNumber2();
            model.setNumber1(number1);
            model.setNumber2(number2);
            String operation = view.getOperation();
            try {
                switch (operation) {
                    case "+":
                        model.add();
                        break;
                    case "-":
                        model.subtract();
                        break;
                    case "*":
                        model.multiply();
                        break;
                    case "/":
                        model.divide();
                        break;
                    default:
                        System.out.println("Invalid operation");
                        continue;
                }
                view.printResult(model.getResult());
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
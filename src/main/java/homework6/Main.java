package homework6;


import homework6.Controller.CalculatorController;
import homework6.Model.CalculatorModel;
import homework6.View.CalculatorView;
import homework6.View.ConsoleInput;
import homework6.View.ConsoleOutput;

public class Main {
    public static void main(String[] args) {
        CalculatorModel model = new CalculatorModel();
        CalculatorView view = new CalculatorView(new ConsoleInput(), new ConsoleOutput());
        CalculatorController controller = new CalculatorController(model, view);
        controller.run();
    }
}

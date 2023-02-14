package homework6.Controller;

import homework6.Model.CalculatorModel;
import homework6.View.CalculatorView;

public class CalculatorController {
    private final CalculatorModel model;
    private final CalculatorView view;

    public CalculatorController(CalculatorModel model, CalculatorView view) {
        this.model = model;
        this.view = view;
    }

    public void run() {
        model.setNumber1(view.getNumber1());
        model.setNumber2(view.getNumber2());
        model.setOperation(view.getOperation());

        double result = model.calculate();

        view.showResult(result);
    }
}
package code.apps.simpleCalc;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class CalculatorController {
    private CalculatorModel model;
    private CalculatorView  view;

    private String  previousOperator;
    private boolean isExpectingTheFirstDigitOfAnOperand;

    public CalculatorController(CalculatorModel model) {
        this.model = model;

        ActionListener clearButtonListener = new ClearButtonListener();
        ActionListener digitButtonListener = new DigitButtonListener();
        ActionListener operatorButtonListener = new OperatorButtonListener();

        view = new CalculatorView(digitButtonListener, operatorButtonListener,
                clearButtonListener);

        reset();
    }

    public CalculatorView getView() {
        return view;
    }

    private class ClearButtonListener implements ActionListener {
        public void actionPerformed(ActionEvent actionEvent) {
            reset();
        }
    }

    private class DigitButtonListener implements ActionListener {
        public void actionPerformed(ActionEvent actionEvent) {
            String digit = actionEvent.getActionCommand();

            if (isExpectingTheFirstDigitOfAnOperand) {
                // user just entered a digit,
                // and the controller was expecting it,
                // so this is the first digit of an operand

                isExpectingTheFirstDigitOfAnOperand = false;
                view.setDisplay(digit);
            } else {
                // user just entered a digit,
                // and the controller was expecting either:
                // an operator or another digit,
                // so keep ingesting digits until an operator is seen

                view.setDisplay(view.getDisplay() + digit);
            }

            view.setHistory(view.getHistory() + digit);
        }
    }

    private class OperatorButtonListener implements ActionListener {
        public void actionPerformed(ActionEvent actionEvent) {
            String operator = actionEvent.getActionCommand();

            String history = view.getHistory();
            if (operator.equals("="))
                history += " ";
            else
                history += operator;
            view.setHistory(history);

            if (!isExpectingTheFirstDigitOfAnOperand) {
                // user just entered an operator,
                // and the controller was expecting either:
                // an operator or another digit,
                // so do what the previousOperator specified

                isExpectingTheFirstDigitOfAnOperand = true;

                String operand = view.getDisplay();
                updateModel(operand);

                previousOperator = operator;
                view.setDisplay(model.getMemory());
            } else {
                // user just entered an operator,
                // but the controller was expecting a digit

                reset();
                view.setDisplay("Error - expected a digit");
            }
        }

    }


    /**
     * updateModel takes a String and checks to see what the previous
     * operator was.  Depending on what that operator was, updateModel calls
     * the appropriate method on the operand for CalculatorModel.
     * The operators you need to account for in this assignment are +, -, /, *, and =
     * 
     * Note: +, -, /, and * all expect an additional operand, whereas = does not.
     * 
     * In MVC style code the Controller class (C) will interact with other
     * classes, namely the Model class (M) and the View class (V).
     *
     * @param operand
     */
    public void updateModel(String operand) {
    	switch (previousOperator)
		{
			case "+":
				model.addToMemory(operand);
				break;
			case "-":
				model.subtractFromMemory(operand);
				break;
			case "x":
				model.multiplyMemoryBy(operand);
				break;
			case "/":
				model.divideMemoryBy(operand);
				break;
			case "=":
				model.setMemory(operand);
				break;
		}
    }

    private void reset() {
        previousOperator = "=";
        isExpectingTheFirstDigitOfAnOperand = true;
        model.setMemory("0");
        view.setDisplay("0");
        view.setHistory("");
    }

    protected void setPrevOperator(String op) {
        this.previousOperator = op;
    }
}

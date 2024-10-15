package Calculatrice;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CalculatorController {
    private CalculatorModel model;
    private CalculatorView view;
    private String operator;
    private double firstOperand;

    public CalculatorController(CalculatorModel model, CalculatorView view) {
        this.model = model;
        this.view = view;
        this.view.addActionListener(new ButtonClickListener());
    }

    //Classe pour effectuer les actions sur le click des boutons
    class ButtonClickListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            String command = e.getActionCommand();
            try {
                if (Character.isDigit(command.charAt(0))) {
                    view.setInputField(view.getInputField() + command);
                } else if (command.equals("+") || command.equals("-") || command.equals("*") || command.equals("/")) {
                    firstOperand = Double.parseDouble(view.getInputField());
                    operator = command;
                    view.setInputField("");
                } else if (command.equals(".")) {
                    // Vérifie que le champ n'a pas déjà un point décimal
                    if (!view.getInputField().contains(".")) {
                        view.setInputField(view.getInputField() + ".");
                    }
                } else if (command.equals("=")) {
                    double secondOperand = Double.parseDouble(view.getInputField());
                    String result;
                    switch (operator) {
                        case "+":
                            result = String.valueOf(model.add(firstOperand, secondOperand));
                            break;
                        case "-":
                            result = String.valueOf(model.subtract(firstOperand, secondOperand));
                            break;
                        case "*":
                            result = String.valueOf(model.multiply(firstOperand, secondOperand));
                            break;
                        case "/":
                            result = model.divide(firstOperand, secondOperand);
                            break;
                        default:
                            result = "Error";
                    }
                    view.setInputField(result);
                } else if (command.equals("C")) {
                    // Effacer le champ de saisie (Clear)
                    view.setInputField("");
                } else if (command.equals("←")) {
                    // Supprimer le dernier caractère (Backspace)
                    String currentText = view.getInputField();
                    if (currentText.length() > 0) {
                        view.setInputField(currentText.substring(0, currentText.length() - 1));
                    }
                }
            } catch (NumberFormatException ex) {
                view.setInputField("Error");
            }
        }
    }
}
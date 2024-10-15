package Calculatrice;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class CalculatorView {
    private JFrame frame;
    private JTextField inputField;
    private JButton[] numberButtons;
    private JButton addButton, subtractButton, multiplyButton, divideButton, equalsButton, decimalButton, clearButton, backspaceButton;

    //Création des boutons
    public CalculatorView() {
        frame = new JFrame("Calculator");
        inputField = new JTextField();
        numberButtons = new JButton[10];
        for (int i = 0; i < 10; i++) {
            numberButtons[i] = new JButton(String.valueOf(i));
            numberButtons[i].setBackground(Color.DARK_GRAY);  // Couleur de fond des boutons nombres 
            numberButtons[i].setForeground(Color.WHITE);  // Couleur du texte des boutson nombres
        }
        addButton = new JButton("+");
        subtractButton = new JButton("-");
        multiplyButton = new JButton("*");
        divideButton = new JButton("/");
        equalsButton = new JButton("=");
        equalsButton.setForeground(Color.GREEN);
        decimalButton = new JButton(".");
        clearButton = new JButton("C");  // Bouton Clear
        clearButton.setForeground(Color.RED);
        backspaceButton = new JButton("←");  // Bouton Backspace
        backspaceButton.setForeground(Color.RED); 
        setupLayout();
    }
    
    //Layout de la calculatrice
    private void setupLayout() {
        frame.setLayout(new BorderLayout());
        frame.add(inputField, BorderLayout.NORTH);
        
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(5, 3)); //4 lignes 3 colonnes
    

        panel.add(backspaceButton);  
        panel.add(divideButton);
        panel.add(multiplyButton);

        //Ajout des boutons chiffres
        panel.add(numberButtons[7]);
        panel.add(numberButtons[8]);
        panel.add(numberButtons[9]);
        panel.add(numberButtons[4]);
        panel.add(numberButtons[5]);
        panel.add(numberButtons[6]);
        panel.add(numberButtons[1]);
        panel.add(numberButtons[2]);
        panel.add(numberButtons[3]);
        
        panel.add(clearButton);  
        panel.add(numberButtons[0]);
        panel.add(decimalButton);
        
        // Ajout des opérations et résultat
        JPanel operationPanel = new JPanel();
        operationPanel.setLayout(new GridLayout(3, 1));  // 4 lignes pour les opérations
        operationPanel.add(subtractButton);
        operationPanel.add(addButton);
        operationPanel.add(equalsButton);


    
        // Ajouter les panels à la fenêtre
        frame.add(panel, BorderLayout.CENTER);
        frame.add(operationPanel, BorderLayout.EAST);
        frame.setSize(400, 400);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
    

    // Méthode pour récupérer le texte du champ de saisie
    public String getInputField() {
        return inputField.getText();
    }

    // Méthode pour définir le texte du champ de saisie
    public void setInputField(String text) {
        inputField.setText(text);
    }

    //Classe pour controller
    public void addActionListener(ActionListener listener) {
        for (JButton button : numberButtons) {
            button.addActionListener(listener);
        }
        addButton.addActionListener(listener);
        subtractButton.addActionListener(listener);
        multiplyButton.addActionListener(listener);
        divideButton.addActionListener(listener);
        equalsButton.addActionListener(listener);
        decimalButton.addActionListener(listener);
        clearButton.addActionListener(listener);  // Ajouter l'action au bouton Clear
        backspaceButton.addActionListener(listener);  // Ajouter l'action au bouton Backspace
    }
}

package Calculatrice;
public class CalculatorModel {
    //Addition
    public double add(double a, double b) {
        return a + b;
    }
    //Soustraction
    public double subtract(double a, double b) {
        return a - b;
    }
    //Multiplication
    public double multiply(double a, double b) {
        return a * b;
    }
    //Division + erreur si division par 0
    public String divide(double a, double b) {
        if (b == 0) {
            return "Error: Division by zero";
        }
        return String.valueOf(a / b);
    }
}
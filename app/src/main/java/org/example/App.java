package org.example;

public class App {
    public static void main(String[] args) {
        Calculator calculator = new Calculator();

        System.out.println(calculator.evaluate("2+5"));       // Output: 7
        System.out.println(calculator.evaluate("3+6*5"));     // Output: 33
        System.out.println(calculator.evaluate("4*(2+3)"));   // Output: 20
        System.out.println(calculator.evaluate("(7+9)/8"));   // Output: 2
    }
}

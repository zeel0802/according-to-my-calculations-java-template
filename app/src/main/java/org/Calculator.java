package org.example;

import java.util.Stack;
import java.util.Queue;
import java.util.LinkedList;
import java.util.HashMap;

public class Calculator {

    public double evaluate(String expression) {
        Queue<String> postfix = infixToPostfix(expression);
        return evaluatePostfix(postfix);
    }

    private Queue<String> infixToPostfix(String infix) {
        Stack<Character> opStack = new Stack<>();
        Queue<String> outputQueue = new LinkedList<>();
        HashMap<Character, Integer> precedence = new HashMap<>();
        precedence.put('+', 1);
        precedence.put('-', 1);
        precedence.put('*', 2);
        precedence.put('/', 2);

        StringBuilder token = new StringBuilder();
        for (char ch : infix.toCharArray()) {
            if (Character.isDigit(ch)) {
                token.append(ch);
            } else {
                if (token.length() > 0) {
                    outputQueue.add(token.toString());
                    token.setLength(0);
                }

                if (ch == '(') {
                    opStack.push(ch);
                } else if (ch == ')') {
                    while (!opStack.isEmpty() && opStack.peek() != '(') {
                        outputQueue.add(String.valueOf(opStack.pop()));
                    }
                    opStack.pop();
                } else if (precedence.containsKey(ch)) {
                    while (!opStack.isEmpty() && precedence.getOrDefault(opStack.peek(), 0) >= precedence.get(ch)) {
                        outputQueue.add(String.valueOf(opStack.pop()));
                    }
                    opStack.push(ch);
                }
            }
        }

        if (token.length() > 0) {
            outputQueue.add(token.toString());
        }

        while (!opStack.isEmpty()) {
            outputQueue.add(String.valueOf(opStack.pop()));
        }

        return outputQueue;
    }

    private double evaluatePostfix(Queue<String> postfix) {
        Stack<Double> values = new Stack<>();

        while (!postfix.isEmpty()) {
            String token = postfix.poll();

            if (Character.isDigit(token.charAt(0))) {
                values.push(Double.parseDouble(token));
            } else {
                double b = values.pop();
                double a = values.pop();

                switch (token.charAt(0)) {
                    case '+': values.push(a + b); break;
                    case '-': values.push(a - b); break;
                    case '*': values.push(a * b); break;
                    case '/': values.push(a / b); break;
                }
            }
        }
        return values.pop();
    }
}

package com.example.comprehensive_book;

import java.io.IOException;
import java.util.EmptyStackException;
import java.util.Stack;

public class EvaluateExpression {
    public static void main(String[] args) throws IOException {
//        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
//        String expression = input.readLine();
//        String expression = "( 1 + 2 ) * 4 - 3";
//        String expression = "(1) + 2";
        String expression = "(1 + 3 * 3 - 2) * (12 / 6 * 5)";
//        String expression = "(1 + 3 * 3 - 2) * (12 / 6 * 5) +";
//        String expression = "(1 + 2) * 4 - 3";

//        String expression = "3 + (4 + 5) * (4+5) + 4 * 5";
//        String expression = "4 + 5 5 5";
        String tokens = insertBlanks(expression);
        String[] splitExpression = tokens.split(" ");
        Stack<Integer> operandStack = new Stack<>();
        Stack<String> operatorStack = new Stack<>();

        try {
            calculateExpression(splitExpression, operandStack, operatorStack);
            System.out.println(operandStack.pop());
        } catch (EmptyStackException e){
            System.out.println("Wrong expression: "+expression);
        }


    }

    private static void calculateExpression(String[] splitExpression, Stack<Integer> operandStack, Stack<String> operatorStack) throws EmptyStackException {
        for (String token : splitExpression) {
            if(token.isEmpty()){
                continue;
            }
            else if(token.charAt(0) == '+' || token.charAt(0) == '-'){
                while(!operatorStack.isEmpty() && (operatorStack.peek().equals("+") || operatorStack.peek().equals( "-") ||
                        operatorStack.peek().equals( "*") || operatorStack.peek().equals( "/"))){
                    processAnOperator(operandStack, operatorStack);
                }
                operatorStack.push(token);
            } else if(token.charAt(0) == '*' || token.charAt(0) == '/'){
                while(!operatorStack.isEmpty() && (operatorStack.peek().equals( "*") || operatorStack.peek().equals( "/"))){
                    processAnOperator(operandStack, operatorStack);
                }
                operatorStack.push(token);
            } else if(token.charAt(0) == '('){
                operatorStack.push(token);
            } else if(token.charAt(0) == ')'){
                while (!operatorStack.peek().equals("(")) {
                    processAnOperator(operandStack, operatorStack);
                }
                operatorStack.pop();
            } else {
                operandStack.push(Integer.valueOf(token));
            }

        }
        while (!operatorStack.isEmpty()){
            processAnOperator(operandStack, operatorStack);
        }
    }

    private static String insertBlanks(String expression) {
        String result = "";
        for (int i = 0; i < expression.length(); i++) {
            if(expression.charAt(i) == '(' || expression.charAt(i) == ')'
                    || expression.charAt(i) == '+' || expression.charAt(i) == '-'
                    || expression.charAt(i) == '*' || expression.charAt(i) == '/'){
                if(expression.charAt(i) == '(' && result.length() == 0){
                    result = expression.charAt(i) + " ";
                } else if(expression.charAt(i) == ')' && expression.length()-1 == i){
                    result += " " + expression.charAt(i);
                } else {
                    result += " " + expression.charAt(i) + " ";
                }
            } else {
                if(expression.charAt(i) != ' ') {
                    result += expression.charAt(i);
                }
            }
        }
        return result;
    }

    private static void processAnOperator(Stack<Integer> operandStack, Stack<String> operatorStack) throws EmptyStackException {
        try {
            Integer num1 = operandStack.pop();
            Integer num2 = operandStack.pop();
            String operator = operatorStack.pop();
            if(operator.equals("+")){
                operandStack.push(num1 + num2);
            } else if(operator.equals("-")){
                operandStack.push(num2 - num1);
            } else if(operator.equals("*")){
                operandStack.push(num1 * num2);
            } else if(operator.equals("/")){
                operandStack.push(num2 / num1);
            }
        } catch (EmptyStackException e){
            throw new EmptyStackException();
        }

    }
}

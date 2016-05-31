package com.example.pattern.stategy;

public class StrategyPatternDemo {
    public static void main(String[] args) {
        int num1;
        int num2 = num1 = 10;
        Strategy add = new OperationAdd();
        Context addContext = new Context(add);
        System.out.println(addContext.executeStategy(num1, num2));

        Context substract = new Context(new SubstractOperation());
        System.out.println(substract.executeStategy(num1, num2));

        Context multiply = new Context(new MutiplyOperation());
        System.out.println(multiply.executeStategy(num1, num2));
    }


}

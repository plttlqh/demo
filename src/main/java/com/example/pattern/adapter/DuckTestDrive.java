package com.example.pattern.adapter;

public class DuckTestDrive {
    public static void main(String[] args) {
        MallardDuck duck = new MallardDuck();

        WildTurkey turkey = new WildTurkey();
        Duck turkeyAdapter = new TurkeyAdapter(turkey);

        System.out.println("The Turkey says...");
        testTurkey(turkey);

        System.out.println("The Duck says...");
        testDuck(duck);

        System.out.println("The TurkeyAdapter says....");
        testDuck(turkeyAdapter);

        System.out.println("The DuckAdapter says....");
        DuckAdapter duckAdapter = new DuckAdapter(duck);
        testTurkey(duckAdapter);

    }

    private static void testTurkey(Turkey turkey) {
        turkey.gobble();
        turkey.fly();
    }

    private static void testDuck(Duck duck) {
        duck.quack();
        duck.fly();
    }
}

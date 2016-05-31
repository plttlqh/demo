package com.example.pattern.singleton;

public class Singleton {

    private static Singleton instance = new Singleton();

    private Singleton() {
    }

    public static Singleton getInstance() {
        return instance;
    }

    protected static void doSomething(){
        System.out.println("This is singleton");
    }
}

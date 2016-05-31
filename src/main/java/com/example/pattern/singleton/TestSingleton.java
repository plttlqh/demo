package com.example.pattern.singleton;

public class TestSingleton {
    public static void main(String[] args) {
        Singleton instance = Singleton.getInstance();
        instance.doSomething();

        Singleton instance2 = Singleton.getInstance();
        instance2.doSomething();
    }
}

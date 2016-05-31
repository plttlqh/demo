package com.example.pattern.stategy;

public class SubstractOperation implements Strategy {
    @Override
    public int doOperation(int A, int B) {
        return A - B;
    }
}

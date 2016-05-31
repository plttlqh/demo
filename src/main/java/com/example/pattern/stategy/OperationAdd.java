package com.example.pattern.stategy;

public class OperationAdd implements Strategy {
    @Override
    public int doOperation(int A, int B) {
        return A + B;
    }
}

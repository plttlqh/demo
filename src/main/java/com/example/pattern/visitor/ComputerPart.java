package com.example.pattern.visitor;

public interface ComputerPart {
    void accept(ComputerPartVisitor computerPartVisitor);
}

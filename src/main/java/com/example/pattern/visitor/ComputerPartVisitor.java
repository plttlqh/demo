package com.example.pattern.visitor;

public interface ComputerPartVisitor {
    void visit(Computer computerPart);
    void visit(Mouse mouse);
    void visit(Keyboard keyboard);
    void visit(Monitor monitor);
}

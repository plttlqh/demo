package com.example.pattern.decorating;

public abstract class Beverage {
    protected String description = "Unknow bevarage";

    public String getDescription() {
        return description;
    }

    public abstract double cost();
}

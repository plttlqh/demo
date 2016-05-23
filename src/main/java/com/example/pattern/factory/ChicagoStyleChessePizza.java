package com.example.pattern.factory;

public class ChicagoStyleChessePizza extends Pizza {
    public ChicagoStyleChessePizza() {
        name = "Chicago Style Sauce and Cheese Pizza";
        dough = "Extra Thin Crust Dough";
        sauce = "Plum Tomato Sauce";

        toppings.add("Shredded Mozzarella Cheese");
    }

    @Override
    void cut() {
        System.out.println("Cutting the pizza into square slices");
    }
}

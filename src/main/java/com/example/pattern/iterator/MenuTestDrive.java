package com.example.pattern.iterator;

import java.util.ArrayList;
import java.util.List;

public class MenuTestDrive {
    public static void main(String[] args) {
        MenuItem[] pancakeMenuItems = {new MenuItem("Vegetarian BLT", "Bacon with lettuce & tomato on whole wheet", true, 2.99),
                new MenuItem("BLT", "Bacon with lettuce & tomato on whole wheet", false, 2.99),
                new MenuItem("Soup of the day", "Soup of the day, with a side of potato salad", false, 3.29)
        };
        MenuItem[] dinerMenuItems = {new MenuItem("K&B's Pancake Breakfast", "Pancakes with scrambled eggs", true, 2.99),
                new MenuItem("Regular Pancake Breakfast", "Bacon with freied eggs, sausage", false, 2.99),
                new MenuItem("Blueberry Pancake", "Pancakes made with fresh blueberries", true, 3.49)
        };
        CafeMenu cafeMenu = new CafeMenu();
        PancakeHouseMenu pancakeHouseMenu = new PancakeHouseMenu(pancakeMenuItems);
        DinerMenu dinerMenu = new DinerMenu(dinerMenuItems);
        List list = new ArrayList<>();
        list.add(cafeMenu);
        list.add(pancakeHouseMenu);
        list.add(dinerMenu);
        Waitress waitress = new Waitress(list);
        waitress.printMenu();
    }
}

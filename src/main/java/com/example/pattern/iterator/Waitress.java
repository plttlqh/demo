package com.example.pattern.iterator;

import java.util.Iterator;
import java.util.List;

public class Waitress {
    List menu;

    public Waitress(List menu) {
        this.menu = menu;
    }

    public void printMenu(){
        Iterator iterator = menu.iterator();
        while (iterator.hasNext()){
            Menu menu = (Menu) iterator.next();
            printMenu(menu.createIterator());
        }
    }

    private void printMenu(Iterator iterator) {
        while (iterator.hasNext()){
            MenuItem menuItem = (MenuItem) iterator.next();
            System.out.println(menuItem.getName() + ", ");
            System.out.println(menuItem.getPrice() + " -- ");
            System.out.println(menuItem.getDescription());
        }
    }
}

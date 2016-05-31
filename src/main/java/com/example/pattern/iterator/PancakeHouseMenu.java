package com.example.pattern.iterator;

import java.util.Iterator;

public class PancakeHouseMenu implements Menu {
    static final int MAX_ITEMS = 6;
    int numberOfItems = 0;
    MenuItem[] menuItems;

    public PancakeHouseMenu(MenuItem[] menuItems) {
        this.menuItems = menuItems;
    }

    public Iterator createIterator(){
        return new PancakeHouseMenuIterator(menuItems);
    }
}

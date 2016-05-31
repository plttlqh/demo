package com.example.pattern.iterator;

import java.util.Iterator;

public class PancakeHouseMenuIterator implements Iterator {
    MenuItem[] items;
    int position;

    public PancakeHouseMenuIterator(MenuItem[] items) {
        this.items = items;
    }

    @Override
    public boolean hasNext() {
        if(position >= items.length || items[position] == null){
            return false;
        }
        return true;
    }


    @Override
    public Object next() {
        MenuItem item = items[position];
        position +=1;
        return item;
    }

    @Override
    public void remove() {
        if(position <= 0){
            throw new IllegalStateException("You can't remove an item until you've done at least one next()");
        }
        if(items[position] != null){
            for (int i = position - 1; i < items.length - 1; i++) {
                items[i] = items[i+1];
            }
            items[items.length - 1] = null;
        }
    }
}

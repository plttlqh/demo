package com.example.collection;

import java.util.*;

public class TestListSet {
    public static void main(String[] args) {
        String string = "a";
        String b = new String("a");
        String string1 = "a";
        if(string == string1){
            System.out.println("=============");
        }
        System.out.println(string == b);
        if (string == b){
            System.out.println(string == b);
        }




        List<String> testSort = new ArrayList<>();

        testSort.add("A");

        testSort.add("D");
        testSort.add("E");
        testSort.add("E");
        testSort.add("a");
        testSort.add("e");
        testSort.add("C");
        testSort.forEach(System.out::print);
        System.out.println(testSort.get(4));
        System.out.println();
        System.out.println("sort list");

        Set<String> testSortSet = new HashSet<>();
        testSortSet.add("A");
        testSortSet.add("E");
        testSortSet.add("D");
        testSortSet.add("E");
        testSortSet.add("a");
        testSortSet.add("e");
        testSortSet.add("C");
        testSortSet.forEach(System.out::print);
        System.out.println();
        System.out.println("sort set");


        List<String> al = new ArrayList<>();
        al.add("Chaitanya");
        al.add("Rahul");
        al.add("Ajeet");
        System.out.println("ArrayList Elements: ");
        System.out.print(al);

        List<String> ll = new LinkedList<>();
        ll.add("Kevin");
        ll.add("Peter");
        ll.add("Kate");
        System.out.println("\nLinkedList Elements: ");
        System.out.print(ll);
    }

}

package com.example.benchmark;

import com.example.benchmark.customCollections.CustomArrayList;
import com.example.benchmark.customCollections.CustomLinkedList;

import java.util.ArrayList;
import java.util.LinkedList;

public class TestCustomCollections {
    public static void main(String[] args) {
        CustomArrayList<Integer> customArrayList = new CustomArrayList<>();
        customArrayList.add(10);
        customArrayList.add(20);
        customArrayList.add(30);
        customArrayList.add(40);
        customArrayList.add(41);
        customArrayList.add(42);
        customArrayList.add(43);
        customArrayList.add(44);
        customArrayList.add(45);
        customArrayList.add(46);
        customArrayList.add(47);
        customArrayList.add(48);
        customArrayList.remove(customArrayList.size()/2);
        System.out.println(customArrayList);
        for (Integer ii : customArrayList){
            System.out.println(ii);
        }

        LinkedList<String> linkedList = new LinkedList<>();
        linkedList.add("Igor");
        linkedList.add("Max");
        linkedList.add("Den");
        linkedList.add("Alexandr");

        CustomLinkedList<String> customLinkedList = new CustomLinkedList<>();
        customLinkedList.add("Igor");
        customLinkedList.add("Max");
        customLinkedList.add("Den");
        customLinkedList.add("Alexandr");
        System.out.println(customLinkedList.get(1));
        customLinkedList.remove(3);
        customLinkedList.addFirst("Stanislav");
        customLinkedList.addLast("Evgen");
        customLinkedList.remove(2);
        customLinkedList.clear();

    }
}

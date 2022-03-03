package com.example.benchmark;

import com.example.benchmark.models.DataCollections;
import com.example.benchmark.utility.Utils;

import java.util.Collection;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;

public class TestCollections {
    Collection<String> collection;


    Set<String> nameSet = new HashSet<>();

    public static void main(String[] args) {
        DataCollections dc = DataCollections.valuesOf(100);
        LinkedList list = new LinkedList<>();

        System.out.println("==================ArrayList====================================");
        Utils.deltaProfileing(() -> dc.getArrayList().add("value: 321"));
        Utils.deltaProfileing(() -> dc.getArrayList().contains("value12: 321"));
        Utils.deltaProfileing(() -> dc.getArrayList().contains("value: 321"));
        Utils.deltaProfileing(() -> dc.getArrayList().remove(dc.getArrayList().size()-1));
        System.out.println("==================LinkedList====================================");
        Utils.deltaProfileing(() -> dc.getLinkedList().add("value: 321"));
        Utils.deltaProfileing(() -> dc.getLinkedList().contains("value12: 321"));
        Utils.deltaProfileing(() -> dc.getLinkedList().contains("value: 321"));
        Utils.deltaProfileing(() -> dc.getLinkedList().remove(dc.getArrayList().size()-1));
        System.out.println("==================HashSet====================================");
        Utils.deltaProfileing(() -> dc.getHashSet().add("value: 321"));
        Utils.deltaProfileing(() -> dc.getHashSet().contains("value12: 321"));
        Utils.deltaProfileing(() -> dc.getHashSet().contains("value: 321"));
        Utils.deltaProfileing(() -> dc.getHashSet().remove(dc.getArrayList().size()-1));
        System.out.println("===================TreeSet====================================");
        Utils.deltaProfileing(() -> dc.getTreeSet().add("value: 321"));
        Utils.deltaProfileing(() -> dc.getTreeSet().contains("value12: 321"));
        Utils.deltaProfileing(() -> dc.getTreeSet().contains("value: 321"));
        Utils.deltaProfileing(() -> dc.getTreeSet().remove("value: 321"));
        System.out.println("===================HashMap====================================");
        Utils.deltaProfileing(() -> dc.getHashMap().put(dc.getHashMap().size()+1, "value: 321"));
        Utils.deltaProfileing(() -> dc.getHashMap().containsKey("value12: 321"));
        Utils.deltaProfileing(() -> dc.getHashMap().containsKey("value: 321"));
        Utils.deltaProfileing(() -> dc.getHashMap().containsValue("value12: 321"));
        Utils.deltaProfileing(() -> dc.getHashMap().containsValue("value: 321"));
        Utils.deltaProfileing(() -> dc.getHashMap().remove("value: 321"));
        System.out.println("==============================================================");
    }
}

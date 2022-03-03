package com.example.benchmark.models;

import java.util.*;

public class DataCollections {
    private int count = 100;
    private List<String> linkedList;
    private List<String> arrayList;
    private Set<String> hashSet;
    private Set<String> treeSet;
    private Vector<String> vector;
    private HashMap<Integer, String> hashMap;

    public static DataCollections valuesOf(int count){
        return new DataCollections(count);
    }

    private DataCollections(int count) {
        createData();
    }

    private DataCollections() {
        this.count = 1000;
        createData();
    }

    public int getN() {
        return count;
    }

    public List<String> getLinkedList() {
        return linkedList;
    }

    public List<String> getArrayList() {
        return arrayList;
    }

    public Set<String> getHashSet() {
        return hashSet;
    }

    public Set<String> getTreeSet() {
        return treeSet;
    }

    public Vector<String> getVector() {
        return vector;
    }

    public HashMap<Integer, String> getHashMap() {
        return hashMap;
    }

    private void createData() {
        arrayList = new ArrayList<>();
        linkedList = new LinkedList<>();
        hashSet = new HashSet<>();
        treeSet = new TreeSet<>();
        vector = new Vector<>();
        hashMap = new HashMap<>();
        for (int i = 0; i < count; i++) {
            arrayList.add("value : " + i);
            linkedList.add("value : " + i);
            hashSet.add("value : " + i);
            treeSet.add("value : " + i);
            vector.add("value : " + i);
            hashMap.put(i, "value : " + i);
        }
    }
}

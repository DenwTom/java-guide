package com.example.benchmark.customCollections;

public interface CustomCollection<E> {
    E get(int index);
    int size();
    boolean add(E e);
    void remove(int index);
}

package com.example.benchmark.customCollections;

import java.util.Iterator;

public class CustomIterator<E> implements Iterator {
    int currIndex = 0;
    E[] arrData;

    public CustomIterator(E[] arrData) {
        this.arrData = arrData;
    }

    @Override
    public boolean hasNext() {
        return currIndex < arrData.length;
    }

    @Override
    public E next() {
        return arrData[currIndex++];
    }
}

package com.example.benchmark.customCollections;

import org.apache.commons.math3.exception.OutOfRangeException;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;


public class CustomArrayList<E> implements Iterable<E>, CustomCollection<E>{
    private static final int DEFAULT_CAPACITY = 10;
    private static final int MAX_ARRAY_SIZE = Integer.MAX_VALUE - 8;
    private E[] elementData;
    private int size;


    public CustomArrayList(int initialCapacity) {
        if (initialCapacity > 0) {
            this.elementData = (E[]) new Object[initialCapacity];
        } else if (initialCapacity == 0) {
            this.elementData = (E[]) new Object[]{};
        } else {
            throw new IllegalArgumentException(">> --- Illegal Capacity: "+
                    initialCapacity);
        }
    }

    public CustomArrayList() {
        elementData = (E[]) new Object[DEFAULT_CAPACITY];
    }


    public E get(int index){
        checkIndex(index, size);
        return (E)elementData[index];
    }

    public int size(){
        return size;
    }


    public void add(int index, E elementVal){
        checkIndex(index, size);
        for(int i = size; i>index; i--){
            elementData[i] = elementData[i-1];
        }
        elementData[index] = elementVal;
        size++;
    }

    public boolean add(E e){
        try {
            E[] elementDataRes = elementData;
            if(size == elementData.length) {
                elementData = (E[]) new Object[elementDataRes.length + elementDataRes.length / 2];
                System.arraycopy(elementDataRes, 0, elementData, 0, elementDataRes.length);//Arrays.copyOf() ?
                elementData[elementDataRes.length] = e;
                size++;
            }else
                elementData[size++] = e;
            return true;
        }catch (ClassCastException ex){
            ex.printStackTrace();
        }
        return false;
    }

    public void remove(int index){
        for (int i = index; i<size; i++)
            elementData[i] = elementData[i+1];
        elementData[size] = null;
        size--;
    }

    public void set(int index, E element) {
        checkIndex(index, elementData.length);
        elementData[index] = element;
    }


    private boolean checkIndex(int index, int size){
        if (index < 0 || index >= size)
            throw new IllegalArgumentException(">> -----Illegal index...");
        return true;
    }


    @Override
    public Iterator<E> iterator() {
        return new CustomIterator<E>(elementData);
    }


    @Override
    public String toString() {
        return Arrays.toString(Arrays.copyOf(elementData, size));
    }
}

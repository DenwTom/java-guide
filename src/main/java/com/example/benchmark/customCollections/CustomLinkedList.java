package com.example.benchmark.customCollections;

import java.util.HashSet;
import java.util.LinkedList;


public class CustomLinkedList<T> implements CustomCollection<T>{
    private Node<T> head;
    private Node<T> tail;
    private int size;

    public CustomLinkedList() {
        head = new Node<T>(null, null, null);
        tail = new Node<T>(null, null, head);
        head.next = tail;

    }

    public void addFirst(T t){
        if(head == null) {
            head = new Node<>(t, null, null);
            return;
        }
        Node<T> newFirst = new Node<>(t, head, null);
        head.prev = newFirst;
        head = newFirst;
    }

    public void addLast(T t){
        if(head == null) {
            head = new Node<>(t, null, null);
            return;
        }
        Node<T> newLast = new Node<T>(t, null, tail);
        tail.next = newLast;
        tail = newLast;
    }


    @Override
    public T get(int index) {
        if(!(index >= 0 && index < size)){
            throw new IndexOutOfBoundsException("Index: "+index+", Size: "+size);
        }
        Node result = head;
        for (int i = 0; i < index; i++) {
            result = result.next;
        }
        return (T) result.value;
    }

    @Override
    public int size() {
        int size=0;
        Node<T> node;
        for(node=head; node!=null; node=node.next){
            size++;
        }
        return size;
    }

    @Override
    public boolean add(T t) {
        Node newNode = new Node(t, null, null);
        if(isEmpty()){
            head = tail= newNode;
        } else {
            tail.next = newNode;
            newNode.prev = tail;
            tail = newNode;
        }
        size++;
        return true;
    }

    @Override
    public void remove(int index) {
        if (index < 0 || index > size - 1) {
            throw new IllegalArgumentException();
        }
        if (index == 0) {
            head = head.next;
        } else {
            Node node = findNodeBeforeByIndex(index);
            Node tmp = findByIndex(index);
            node.next = tmp.next;
        }
        size--;
    }



    private Node findNodeBeforeByIndex(int index) {
        if (index <= 0 || index > size - 1) {
            return null;
        }

        int count = 0;
        Node node = head;
        while (node.next != null) {
            if (count == index - 1) {
                return node;
            }
            count++;
            node = node.next;
        }
        return null;
    }




    private Node findByIndex(int index) {
        if (index < 0 || index > size - 1) {
            throw new IndexOutOfBoundsException();
        }
        int tmpIndex = 0;
        if (head == null) {
            throw new IndexOutOfBoundsException();
        }

        if (index == 0) {
            return head;
        }

        Node node = head;
        while (node.next != null) {
            node = node.next;
            tmpIndex++;
            if (tmpIndex == index) {
                return node;
            }
        }
        throw new IndexOutOfBoundsException();
    }


    public boolean isEmpty() {
        return size == 0;

    }

    private static class Node<T>{
        private T value;
        private Node<T> next;
        private Node<T> prev;


        public Node(T value, Node<T> next, Node<T> prev) {
            this.value = value;
            this.next = next;
            this.prev = prev;
        }

    }

    public void clear() {
        head = new Node<T>(null, null, null);
        tail = new Node<T>(null, null, head);
        head.next = tail;
        size = 0;
    }

}

package com.revature.util;

public class LinkedList<T> {

    private int size;
    private Node<T> head;
    private Node<T> tail;

    public void insert(T data) {

    }

    public T getFirst() {
        return null;
    }

    public void deleteFirst() {

    }

    public boolean contains(T data) {
        return false;
    }

    public int size() {
        return size;
    }

    public void printList() {
        
    }

    private static class Node<T> {
        T data;
        Node<T> nextNode;
        Node<T> prevNode;

        Node(T data) {
            this.data = data;
        }

        public Node(T data, Node<T> nextNode, Node<T> prevNode) {
            this(data);
            this.prevNode = nextNode;
            this.prevNode = prevNode;
        }
    }


}

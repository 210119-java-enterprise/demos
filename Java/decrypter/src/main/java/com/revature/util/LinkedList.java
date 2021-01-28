package com.revature.util;

public class LinkedList<T> {

    private int size;
    private Node<T> head;
    private Node<T> tail;

    // Adds to tail
    public void insert(T data) {
        if (data == null) {
            return;
        }
        Node<T> node = new Node<>(data, null, null);
        if (head == null) {
            tail = head = node;
        } else {
            tail.nextNode = node;
            node.prevNode = tail;
            tail = node;
        }
        size++;
    }

    public T findFirst(T data) {
        if (data == null) {
            return null;
        }

        for (Node<T> currentNode = head; currentNode != null; currentNode = currentNode.nextNode){
            if (currentNode.data.equals(data)) {
                return null;
            }
        }

        return null;
    }

    public T pop() {

        if (size == 0) {
            return null;
        }

        T data = head.data;

        if (size == 1) {
            head = tail = null;
        } else {
            head = head.nextNode;
            head.prevNode = null;
        }

        size--;

        return data;
    }

    public T peek() {
        return (head == null)? null : head.data;
    }

    public boolean contains(T data) {
        if (data == null) {
            return false;
        }

        for (Node<T> currentNode = head; currentNode != null; currentNode = currentNode.nextNode){
            if (currentNode.data.equals(data)) {
                return true;
            }
        }

        return false;
    }

    public int size() {
        return size;
    }

    public void printList() {
        for (Node<T> currentNode = head; currentNode != null; currentNode = currentNode.nextNode){
            System.out.println(currentNode.data);
        }
    }

    private static class Node<T> {
        T data;
        Node<T> nextNode;
        Node<T> prevNode;

        Node(T data) {
            this.data = data;
        }

        //
        public Node(T data, Node<T> nextNode, Node<T> prevNode) {
            this(data);
            this.prevNode = nextNode;
            this.prevNode = prevNode;
        }
    }


}

package com.revature.util;

public class LinkedList<T> {

    private int size;
    private Node<T> head;
    private Node<T> tail;

    public T findFirst(T data) {
        Node<T> currentNode = head;

        while(currentNode != null) {
            if(currentNode.data.equals(data)) {
                return currentNode.data;
            }
            currentNode = currentNode.nextNode;
        }

        return null;
    }

    public void insert(T data) {

        if(data == null){
            return;
        }

        Node<T> newNode = new Node<>(data);
        if(head == null) {
            tail = head = newNode;
        } else {
            tail.nextNode = newNode;
            newNode.prevNode = tail;
            tail = newNode;
        }

        size++;
    }

    public T pop() {

        if(head == null) {
            return null;
        }

        T popped = head.data;
        head = head.nextNode;

        if(head != null) {
            head.prevNode = null;
        }
        size--;

        return popped;
    }

    public T peek() {
        return (head == null) ? null : head.data;
    }

    public boolean contains(T data) {

        if(data == null){
            return false;
        }

        Node<T> currentNode = head;

        while(currentNode != null) {
            if(currentNode.data.equals(data)) {
                return true;
            }
            currentNode = currentNode.nextNode;
        }

        return false;
    }

    public int size() {
        return size;
    }

    public void printList() {
        Node<T> currentNode = head;
        while(currentNode != null) {
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

        public Node(T data, Node<T> nextNode, Node<T> prevNode) {
            this(data);
            this.nextNode = nextNode;
            this.prevNode = prevNode;
        }

    }

}

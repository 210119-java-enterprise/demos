package com.revature.util;

public class MyLinkedList<T> {
    private static class Node<T> {
        T data;
        Node<T> myNext, myPrevious;

        public Node(T data) {
            this.data = data;
        }

        public Node(T data, Node<T> next, Node<T> previous) {
            this(data);
            this.myNext = next;
            this.myPrevious = previous;
        } 
    }

    private Node<T> head, tail;
    private int size;

    public MyLinkedList() {
        head = tail = null;
        size = 0;
    }

    /*
        Adds a node with the given data onto the list
    */
    public void append(T data) {
        Node<T> newTail;
        if (size == 0) {
            newTail = new Node<T>(data, null, null);
            head = newTail;
        } else {
            newTail = new Node<T>(data);
            newTail.myNext = null;
            newTail.myPrevious = tail;
            tail.myNext = newTail;
        }
        tail = newTail;
        size++;
    }

    /*
        Returns the data of the first Node in the list
    */
    public T getFirst() {
        return head.data;
    }

    /*
        Deletes the first element in the list
    */
    public void deleteFirst() {
        head = head.myNext;
        size--;
    }

    /*
        Deletes the last element in the list
    */
    public void deleteLast() {
        tail = tail.myPrevious;
        tail.myNext = null;
        size--;
    }

    /*
        Searches for a Node containing data and returns whether the Node exists
    */
    public Boolean contains(T data) {
        if (head == null) {
            return false;
        }
        Node<T> currentNode = head;
        while(currentNode != null) {
            if (currentNode.data.equals(data)) {
                return true;
            } else {
                currentNode = currentNode.myNext;
            }
        }
        return false;
    }

    public int size() {
        return size;
    }

    /*
        Prints all items in the list separated by tabs
    */
    public void printList() {
        Node<T> currentNode = head;
        while(currentNode != null) {
            System.out.println(currentNode.data + "\t");
        }
        System.out.println();
    }

    /*
        Searches for the first match to input and deletes that node
        Returns true if a node was deleted
        Returns false is no node was deleted
    */
    public Boolean remove(T data) {
        Node<T> currentNode = head;
        while(currentNode != null) {
            if (currentNode.data.equals(data)) {
                currentNode.myPrevious.myNext = currentNode.myNext;
                currentNode.myNext.myPrevious = currentNode.myPrevious;
                size--;
                return true;
            }
        }
        return false;
    }
}

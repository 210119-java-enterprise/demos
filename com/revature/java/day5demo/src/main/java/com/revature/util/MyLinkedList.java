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
        Does not accept null items
    */
    public void append(T data) {
        if (data == null) {
            return;
        }
        Node<T> newTail;
        if (size == 0) {
            newTail = new Node<T>(data, null, null);
            head = newTail;
        } else {
            newTail = new Node<T>(data);
            newTail.myPrevious = tail;
            tail.myNext = newTail;
        }
        tail = newTail;
        size++;
    }

    /*
        Returns the data of the first Node in the list
        Returns null if the list is empty
    */
    public T peek() {
        return head == null? null: head.data;
    }

    /*
        Returns the data of the last Node in the list
        Returns null if the list is empty
    */
    public T peekLast() {
        return tail == null? null: tail.data;
    }

    /*
        Deletes the first element in the list
        Returns the data from deleted element or null if list is empty
    */
    public T pop() {
        if (head == null) {
            return null;
        }
        T temp = head.data;
        if (size > 1) {
            head = head.myNext;
            head.myPrevious = null;
        } else {
            head = tail = null;
        }
        size--;
        return temp;
    }

    /*
        Deletes the last element in the list
        Returns the data from deleted element or null if list is empty
    */
    public T popLast() {
        if (head == null) {
            return null;
        }
        T temp = tail.data;
        if (size > 1) {
            tail = tail.myPrevious;
            tail.myNext = null;
        } else {
            head = tail = null;
        }
        size--;
        return temp;
    }

    /*
        Searches for a Node containing data and returns whether the Node exists
    */
    public Boolean contains(T data) {
        if (head == null || data == null) {
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

    /*
        Returns the size of the array
    */
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
            currentNode = currentNode.myNext;
        }
        System.out.println();
    }

    /*
        Searches for the first match to input and deletes that node
        Returns true if a node was deleted
        Returns false is no node was deleted
    */
    public Boolean remove(T data) {
        if (data == null) {
            return false;
        }
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

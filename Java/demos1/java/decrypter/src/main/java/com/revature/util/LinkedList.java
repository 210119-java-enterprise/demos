package com.revature.util;

//keep track of head of list, tail of list, and size
//closer to true definition of linked list compared to javas implementation
public class LinkedList<T> {

    private int size;
    private Node<T> head;
    private Node<T> tail;

    //declared static because every linked list that is created can use the node class
    private static class Node<T> {
        T data;
        Node<T> nextNode;
        Node<T> prevNode;

        Node(T data) {
            this.data = data;
        }

        Node(T data, Node<T> nextNode, Node<T> prevNode) {
            this(data);
            this.nextNode = nextNode;
            this.prevNode = prevNode;
        }
    }

    public void insert(T data) {

        //does not accept null items
        if (data == null) {
            return;
        }

        Node<T> newNode = new Node<T>(data);
        if (head == null) {
            tail = head = newNode;
        } else {
            tail.nextNode = newNode;
            newNode.prevNode = tail;
            tail = newNode;
        }
        size++;
    }

    public T getFirst(T data) {
        System.out.println("getFirst called");
        for (Node<T> cur = head; cur != null; cur = cur.nextNode ) {
            if (cur.data.equals(data)) {
                return cur.data;
            }
        }
        return null;
    }

    //get data and remove from front
    //still a little ugly but works ***** returns null when list empty
    public T pop() {
        //System.out.println("popping");
        if (head.data != null) {
            T popped = head.data;
            head.data = null;
            if (head.nextNode != null)
                head = head.nextNode;
            head.prevNode = null;
            size --;
            return popped;
        } else {
            return null;
        }
    }

    public T peak() {
        // so basically checking to see if head is null - if it is return null else return head.data
        return (head == null) ? null : head.data;
    }

    public void deleteFirst(T data) {
        if (data == null) {}
        for(Node cur = head; cur != null; cur = cur.nextNode ) {

        }
    }

    public boolean contains(T data) {

        if (data == null) {
            return false;
        }

//        Node<T> currentNode = head;
//
//        while (currentNode != null) {
//            if (currentNode.data.equals(data)) {
//                return true;
//            }
//            currentNode = currentNode.nextNode;
//        }

        for (Node<T> cur = head; cur != null; cur = cur.nextNode ) {
            if (cur.data.equals(data)) {
                return true;
            }
        }

        return false;
    }

    public int size() {
        return size;
    }

    public void printList() {
        for (Node<T> cur = head; cur != null; cur = cur.nextNode ) {
            System.out.println(cur.data);
        }
    }

}

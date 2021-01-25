package com.revature.util;

public class LinkedList<T> {

    private int size;
    private Node<T> head;
    private Node<T> tail;

    // Adds to tail
    public void insert(T data) {
        Node<T> node = new Node<>(data, tail, null);
        tail.prevNode = node;
        tail = node;
        size++;
    }

    public T getFirst() {
        return head.data;
    }

    public void deleteFirst() {
        Node<T> newHead = head.prevNode;
        newHead.nextNode = null;
        head = newHead;
        size--;
    }

    public boolean contains(T data) {
        Node<T> currentNode = head;
        for (int i  = 1; i < size(); i++) {
            if (currentNode.data == data) {
                return true;
            }
            currentNode = head.nextNode;
        }
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

        //
        public Node(T data, Node<T> nextNode, Node<T> prevNode) {
            this(data);
            this.prevNode = nextNode;
            this.prevNode = prevNode;
        }
    }


}

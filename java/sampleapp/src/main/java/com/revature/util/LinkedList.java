package com.revature.util;

public class LinkedList<T> {

    private int size = 0;
    private Node<T> head;
    private Node<T> tail;

    public void insert(T data){
        if(data == null){
            return;
        }
        if(head == null){
            Node newNode = new Node<T>(data);
            head = newNode;
            head.nextNode = null;
            tail = newNode;
            tail.previousNode = null;
        } else{
            Node newNode = new Node<T>(data,null,tail);
            tail.nextNode = newNode;
            tail = newNode;
        }
        size++;
    }

    public T pop(){
        if(head == null){
            return null;
        }

        T popped = head.data;
        head = head.nextNode;
        head.previousNode = null;
        size--;

        return popped;
    }

    public T peek(){
        return (head == null) ? null : head.data;
    }

    public boolean contains(T data){
        if(data == null){
            return false;
        }

        Node<T> currentNode = head;

        while(currentNode != null){
            if(currentNode.data.equals(data)){
                return true;
            }
            currentNode = currentNode.nextNode;
        }

        return false;
    }

    public int size(){
        return this.size;
    }

    public void printLst(){
        Node<T> currentNode = head;

        while(currentNode != null){
            System.out.println(currentNode.data.toString());
            currentNode = currentNode.nextNode;
        }
    }

    public T findFirst(T data){
        Node<T> currentNode = head;

        while(currentNode != null){
            if(currentNode.data.equals(data)){
                return currentNode.data;
            }
            currentNode = currentNode.nextNode;
        }

        return null;
    }

    private static class Node<T> {
        T data;
        Node<T> nextNode;
        Node<T> previousNode;

        Node(T data){
            this.data = data;
        }

        public Node(T data, Node<T> nextNode, Node<T> previousNode) {
            this(data);
            this.nextNode = nextNode;
            this.previousNode = previousNode;
        }
    }
}

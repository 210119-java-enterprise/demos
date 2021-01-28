package com.revature.util;

public class LinkedList<T> {

    private int size;
    private Node<T> head;
    private Node<T> tail;

//    public T findFirst(){
//        for(Node<T> currentNode = head; currentNode != null; currentNode = currentNode.nextNode){
//            if(currentNode.data.equals(data){
//
//            }
//        }
//    }

    public void insert(T data){
//        Node node = new Node(data);
//        if(head == null){
//            head = node;
//        }
//        else if(tail == null){
//            tail = node;
//            head.nextNode = tail;
//        }
//        else{
//            tail.nextNode = node;
//            tail = node;
//        }

        // this one below will be wezleys
        if(data == null){
            return;
        }
        Node<T> newNode = new Node<>(data);
        if(head == null){
            tail = head = newNode;

        } else{
            tail.nextNode = newNode;
            newNode.prevNode = tail;
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
        head.prevNode = null;

        size--;

        return popped;
    }

    //
    public T peek(){
        return (head == null)? null: head.data;


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
        return size;
    }

    public void printList(){

        for(Node<T> currentNode = head; currentNode != null; currentNode = currentNode.nextNode){

        }
    }




    private static class Node<T>{
        T data;
        Node<T> nextNode;
        Node<T> prevNode;

        Node(T data){
            this.data = data;
        }

        public Node(T data, Node<T> nextNode,Node<T> prevNode){
            this(data);
            this.nextNode = nextNode;
            this.prevNode = prevNode;
        }

    }
}

package com.pacosoft.edfinalproject.collections;

public class Stack<T> {

    private Node<T> head;
    private int length;

    /**
     * Add a new element to the Stack top
     * @param data 
     */
    public void push(T data) {
        Node<T> newNode = new Node<>(data);

        newNode.setNext(head);
        head = newNode;
        length++;
    }

    /**
     * Return the Stack top and remove it
     * @return 
     */
    public T pop() {
        if (isEmpty()) {
            throw new IndexOutOfBoundsException();
        }
        Node<T> top = head;
        head = head.getNext();
        length--;
        return top.getData();
    }

    /**
     * Return the Stack top without remove it
     * @return 
     */
    public T top() {
        if (isEmpty()) {
            throw new IndexOutOfBoundsException();
        }
        return head.getData();
    }

    public boolean isEmpty() {
        return length == 0;
    }
    
    public int size() {
        return length;
    }

    public void clear() {
        head = null;
        length = 0;
    }
}

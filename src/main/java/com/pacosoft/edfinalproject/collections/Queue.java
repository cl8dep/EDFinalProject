package com.pacosoft.edfinalproject.collections;

public class Queue<T> {

    private Node<T> front, last;
    private int lenght;

    public Queue() {
        this.front = this.last = null;
    }

    void enqueue(T value) {
        Node<T> temp = new Node(value);

        if (this.last == null) {
            this.front = this.last = temp;
        } else {
            this.last = temp;
        }
        lenght++;
    }

    public T dequeue() {
        if (this.front == null) {
            throw new IndexOutOfBoundsException();
        }

        Node<T> temp = this.front;
        this.front = this.front.getNext();

        if (this.front == null) {
            this.last = null;
        }
        lenght--;
        
        return temp.getData();
    }
    
    public boolean isEmpty() {
        return lenght == 0;
    }
    
    public int size() {
        return lenght;
    }
}

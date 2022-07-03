package com.pacosoft.edfinalproject.collections;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

public class LinkedList<T> implements Iterable<T>, List<T> {

    private Node<T> head;
    private Node<T> last;
    private int length;

    @Override
    public Iterator<T> iterator() {
        return new LinkedListIterator();
    }

    @Override
    public int size() {
        return length;
    }

    @Override
    public boolean isEmpty() {
        return length == 0;
    }

    @Override
    public boolean contains(Object o) {
        Node<T> cursor = head;
        while (cursor != null) {
            if (cursor.getData().equals(o)) {
                return true;
            }

            cursor = cursor.getNext();
        }
        return false;
    }

    @Override
    public Object[] toArray() {
        Object[] result = new Object[this.size()];
        int i = 0;
        for (Node<T> x = head; x != null; x = x.getNext()) {
            result[i++] = x.getData();
        }
        return result;
    }

    @Override
    public <T> T[] toArray(T[] a) {
        if (a.length < this.size()) {
            a = (T[]) java.lang.reflect.Array.newInstance(
                    a.getClass().getComponentType(), this.size());
        }
        int i = 0;
        Object[] result = a;
        for (Node x = head; x != null; x = x.getNext()) {
            result[i++] = x.getData();
        }

        if (a.length > this.size()) {
            a[this.size()] = null;
        }

        return a;
    }

    @Override
    public boolean add(T e) {
        Node<T> newNode = new Node<>(e);
        if (head == null) {
            head = last = newNode;
        } else {
            newNode.setPrev(last);
            last.setNext(newNode);

            last = newNode;
        }

        length++;
        return true;
    }

    @Override
    public boolean remove(Object o) {
        if (head == null) {
            throw new IndexOutOfBoundsException();
        }

        if (head.getData().equals(o)) {
            head = head.getNext();
            head.setPrev(null);
            length--;
            return true;
        } else {
            Node<T> cursor = head.getNext();
            while (cursor != null) {
                if (cursor.getData().equals(o)) {
                    var prev = cursor.getPrev();
                    var next = cursor.getNext();
                    prev.setNext(next);
                    next.setPrev(prev);
                    length--;
                    return true;
                } else {
                    cursor = cursor.getNext();
                }
            }
        }
        return false;
    }

    @Override
    public boolean containsAll(Collection<?> c) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean addAll(Collection<? extends T> c) {
        for (T item : c) {
            add(item);
        }
        return true;
    }

    @Override
    public boolean addAll(int index, Collection<? extends T> c) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean removeAll(Collection<?> c) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean retainAll(Collection<?> c) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void clear() {
        head = last = null;
        length = 0;
    }

    @Override
    public T get(int index) {
        if (index < length) {
            Node<T> cursor = head;
            for (int i = 0; i <= index; i++) {
                cursor = cursor.getNext();
            }
            return cursor.getData();
        } else {
            throw new IndexOutOfBoundsException();
        }
    }

    @Override
    public T set(int index, T element) {
        if (index < length) {
            Node<T> cursor = head;
            for (int i = 0; i <= index; i++) {
                cursor = cursor.getNext();
            }
            cursor.setData(element);
            return element;
        } else {
            throw new IndexOutOfBoundsException();
        }
    }

    @Override
    public void add(int index, T element) {
        Node<T> newNode = new Node<>(element);
        if (head == null) {
            head = last = newNode;
        } else if (index == 0) {
            newNode.setNext(head);
            head = newNode;

        } else if (index < length) {
            Node<T> cursor = head;
            for (int i = 1; i <= index; i++) {
                cursor = cursor.getNext();
            }
            newNode.setNext(cursor.getNext());
            cursor.setNext(newNode);
        } else {
            last.setNext(newNode);
            last = newNode;
        }

        length++;
    }

    @Override
    public T remove(int index) {
        if (index < length) {
            Node<T> cursor = head;
            for (int i = 0; i <= index - 1; i++) {
                cursor = cursor.getNext();
            }
            Node<T> current = cursor.getNext();
            cursor.setNext(current.getNext());
            length--;
            return current.getData();
        } else {
            throw new IndexOutOfBoundsException();
        }
    }

    @Override
    public int indexOf(Object o) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int lastIndexOf(Object o
    ) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ListIterator<T> listIterator() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ListIterator<T> listIterator(int index
    ) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<T> subList(int fromIndex, int toIndex) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.

    }

    public class LinkedListIterator implements Iterator<T> {

        private int counter;
        private Node<T> cursor;

        LinkedListIterator() {
            cursor = head;
        }

        @Override
        public boolean hasNext() {
            return cursor != null;
        }

        @Override
        public T next() {
            T result = cursor.getData();
            cursor = cursor.getNext();
            return result;
        }

    }

}

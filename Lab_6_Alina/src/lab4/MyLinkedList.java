package lab4;

import java.util.NoSuchElementException;

public class MyLinkedList<T> {
    private Node<T> first;
    public int size;

    public void add(T val) {
        Node<T> newNode = new Node<>(val);
        if (first == null) {
            first = newNode;
        } else {
            Node<T> current = first;
            while (current.next != null) {
                current = current.next;
            }
            current.next = newNode;
        }
        size++;
    }

    public void add(T val, int index) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException("Index out of bounds");
        }
        Node<T> newNode = new Node<>(val);
        if (index == 0) {
            newNode.next = first;
            first = newNode;
        } else {
            Node<T> current = first;
            for (int i = 0; i < index - 1; i++) {
                current = current.next;
            }
            newNode.next = current.next;
            current.next = newNode;
        }
        size++;
    }

    public T remove() {
        if (first == null) {
            throw new NoSuchElementException("List is empty");
        }
        T val = first.value;
        first = first.next;
        size--;
        return val;
    }

    public T remove(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index out of bounds");
        }
        if (index == 0) {
            return remove();
        }
        Node<T> current = first;
        for (int i = 0; i < index - 1; i++) {
            current = current.next;
        }
        T val = current.next.value;
        current.next = current.next.next;
        size--;
        return val;
    }

    public T get(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index out of bounds");
        }
        Node<T> current = first;
        for (int i = 0; i < index; i++) {
            current = current.next;
        }
        return current.value;
    }

    private static class Node<T> {
        Node<T> next;
        T value;

        public Node(T value) {
            this.value = value;
        }
    }
}

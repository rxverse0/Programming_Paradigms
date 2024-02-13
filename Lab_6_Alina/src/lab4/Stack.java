////-----------------> Problem 1.1

 package lab4;

public class Stack<T> {
    private MyLinkedList<T> elements;

    public Stack() {
        elements = new MyLinkedList<>();
    }

    public void push(T e) {
        elements.add(e);
    }

    public T pop() {
        if (elements.size == 0) {
            throw new IllegalStateException("Stack is empty");
        }
        return elements.remove(elements.size - 1);
    }

    public T peek() {
        if (elements.size == 0) {
            throw new IllegalStateException("Stack is empty");
        }
        return elements.get(elements.size - 1);
    }

    public void print() {
        if (elements.size == 0) {
            System.out.println("Stack is empty");
            return;
        }
        System.out.print("Stack: ");
        for (int i = elements.size - 1; i >= 0; i--) {
            System.out.print(elements.get(i) + " ");
        }
        System.out.println();
    }
}
//--------------> Problem 1.2

 class Stack2<T> implements Stackable<T> {
    private MyLinkedList<T> elements;

    public Stack2() {
        elements = new MyLinkedList<>();
    }

    @Override
    public void push(T e) {
        elements.add(e);
    }

    @Override
    public T pop() {
        if (isEmpty()) {
            throw new IllegalStateException("Stack is empty");
        }
        return elements.remove(elements.size - 1);
    }

    @Override
    public void print() {
        if (isEmpty()) {
            System.out.println("Stack is empty");
            return;
        }
        System.out.print("Stack: ");
        for (int i = elements.size - 1; i >= 0; i--) {
            System.out.print(elements.get(i) + " ");
        }
        System.out.println();
    }

    @Override
    public boolean isEmpty() {
        return elements.size == 0;
    }

    @Override
    public T peek() {
        if (isEmpty()) {
            throw new IllegalStateException("Stack is empty");
        }
        return elements.get(elements.size - 1);
    }
}


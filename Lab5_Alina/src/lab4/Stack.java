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

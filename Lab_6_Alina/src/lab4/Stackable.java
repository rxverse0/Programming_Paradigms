package lab4;

public interface Stackable<T> {
    void push(T e);
    T pop();
    void print();
    boolean isEmpty();
    T peek();
}

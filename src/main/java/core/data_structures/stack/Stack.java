package main.java.core.data_structures.stack;

public class Stack<T> {
    private Object[] elements;
    private int size = 0;
    private static final int DEFAULT_CAPACITY = 10;

    public Stack() {
        elements = new Object[DEFAULT_CAPACITY];
    }

    public void push(T value) {
        ensureCapacity();
        elements[size++] = value;
    }

    @SuppressWarnings("unchecked")
    public T pop() {
        if (isEmpty()) throw new RuntimeException("Stack is empty");
        T value = (T) elements[--size];
        elements[size] = null; // очистка ссылки
        return value;
    }

    @SuppressWarnings("unchecked")
    public T peek() {
        if (isEmpty()) throw new RuntimeException("Stack is empty");
        return (T) elements[size - 1];
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int size() {
        return size;
    }

    private void ensureCapacity() {
        if (size == elements.length) {
            Object[] newArray = new Object[elements.length * 2];
            System.arraycopy(elements, 0, newArray, 0, elements.length);
            elements = newArray;
        }
    }

    public void printStack() {
        System.out.print("Stack (top -> bottom): ");
        for (int i = size - 1; i >= 0; i--) {
            System.out.print(elements[i] + " ");
        }
        System.out.println();
    }
}

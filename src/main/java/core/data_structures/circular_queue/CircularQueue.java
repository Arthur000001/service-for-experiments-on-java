package main.java.core.data_structures.circular_queue;

public class CircularQueue<T> {
    private Object[] data;
    private int front = 0;
    private int rear = 0;
    private int size = 0;
    private int capacity;

    public CircularQueue(int capacity) {
        this.capacity = capacity;
        data = new Object[capacity];
    }

    public boolean enqueue(T value) {
        if (isFull()) return false;
        data[rear] = value;
        rear = (rear + 1) % capacity;
        size++;
        return true;
    }

    @SuppressWarnings("unchecked")
    public T dequeue() {
        if (isEmpty()) throw new RuntimeException("Queue is empty");
        T value = (T) data[front];
        data[front] = null; // очистка
        front = (front + 1) % capacity;
        size--;
        return value;
    }

    @SuppressWarnings("unchecked")
    public T peek() {
        if (isEmpty()) throw new RuntimeException("Queue is empty");
        return (T) data[front];
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public boolean isFull() {
        return size == capacity;
    }

    public int size() {
        return size;
    }

    public void printQueue() {
        System.out.print("Queue: ");
        for (int i = 0; i < size; i++) {
            int index = (front + i) % capacity;
            System.out.print(data[index] + " ");
        }
        System.out.println();
    }
}

package main.java.core.data_structures.deque;

public class Deque<T> {
    private static class Node<T> {
        T data;
        Node<T> prev;
        Node<T> next;

        Node(T data) {
            this.data = data;
        }
    }

    private Node<T> head; // начало
    private Node<T> tail; // конец
    private int size = 0;

    public void addFirst(T value) {
        Node<T> newNode = new Node<>(value);
        if (head == null) {
            head = tail = newNode;
        } else {
            newNode.next = head;
            head.prev = newNode;
            head = newNode;
        }
        size++;
    }

    public void addLast(T value) {
        Node<T> newNode = new Node<>(value);
        if (tail == null) {
            head = tail = newNode;
        } else {
            newNode.prev = tail;
            tail.next = newNode;
            tail = newNode;
        }
        size++;
    }

    public T removeFirst() {
        if (head == null) throw new RuntimeException("Deque is empty");
        T value = head.data;
        head = head.next;
        if (head == null) tail = null;
        else head.prev = null;
        size--;
        return value;
    }

    public T removeLast() {
        if (tail == null) throw new RuntimeException("Deque is empty");
        T value = tail.data;
        tail = tail.prev;
        if (tail == null) head = null;
        else tail.next = null;
        size--;
        return value;
    }

    public T peekFirst() {
        if (head == null) throw new RuntimeException("Deque is empty");
        return head.data;
    }

    public T peekLast() {
        if (tail == null) throw new RuntimeException("Deque is empty");
        return tail.data;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int size() {
        return size;
    }

    public void printDeque() {
        Node<T> current = head;
        System.out.print("Deque: ");
        while (current != null) {
            System.out.print(current.data + " ");
            current = current.next;
        }
        System.out.println();
    }
}

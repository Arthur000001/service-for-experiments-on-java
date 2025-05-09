package main.java.core.data_structures.linked_list;

public class LinkedList {
    private Node head;

    // Внутренний класс — узел списка
    private static class Node {
        int data;     // значение
        Node next;    // ссылка на следующий элемент

        Node(int data) {
            this.data = data;
        }
    }

    // Добавить элемент в конец
    public void add(int data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode;
            return;
        }

        Node current = head;
        while (current.next != null) {
            current = current.next;
        }
        current.next = newNode;
    }

    // Удалить элемент по значению
    public void remove(int data) {
        if (head == null) return;

        if (head.data == data) {
            head = head.next;
            return;
        }

        Node current = head;
        while (current.next != null && current.next.data != data) {
            current = current.next;
        }

        if (current.next != null) {
            current.next = current.next.next;
        }
    }

    // Вывести список
    public void printList() {
        Node current = head;
        while (current != null) {
            System.out.print(current.data + " -> ");
            current = current.next;
        }
        System.out.println("null");
    }
}

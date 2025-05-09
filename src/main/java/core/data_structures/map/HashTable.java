package main.java.core.data_structures.map;

public class HashTable<K, V> {
    private static class Node<K, V> {
        K key;
        V value;
        Node<K, V> next;

        Node(K key, V value) {
            this.key = key;
            this.value = value;
        }
    }

    private Node<K, V>[] table;
    private int capacity = 16;

    @SuppressWarnings("unchecked")
    public HashTable() {
        table = new Node[capacity];
    }

    private int hash(K key) {
        return Math.abs(key.hashCode() % capacity);
    }

    public void put(K key, V value) {
        int index = hash(key);
        Node<K, V> head = table[index];

        // Если ключ уже существует — обновим значение
        while (head != null) {
            if (head.key.equals(key)) {
                head.value = value;
                return;
            }
            head = head.next;
        }

        // Вставим в начало списка
        Node<K, V> newNode = new Node<>(key, value);
        newNode.next = table[index];
        table[index] = newNode;
    }

    public V get(K key) {
        int index = hash(key);
        Node<K, V> head = table[index];

        while (head != null) {
            if (head.key.equals(key)) {
                return head.value;
            }
            head = head.next;
        }

        return null; // ключ не найден
    }

    public void remove(K key) {
        int index = hash(key);
        Node<K, V> head = table[index];
        Node<K, V> prev = null;

        while (head != null) {
            if (head.key.equals(key)) {
                if (prev == null) {
                    table[index] = head.next;
                } else {
                    prev.next = head.next;
                }
                return;
            }
            prev = head;
            head = head.next;
        }
    }

    public void printTable() {
        for (int i = 0; i < capacity; i++) {
            System.out.print("[" + i + "]: ");
            Node<K, V> current = table[i];
            while (current != null) {
                System.out.print(current.key + "=" + current.value + " -> ");
                current = current.next;
            }
            System.out.println("null");
        }
    }
}

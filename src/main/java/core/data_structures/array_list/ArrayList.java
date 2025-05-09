package main.java.core.data_structures.array_list;

import java.util.Arrays;

public class ArrayList<T> {
    private Object[] elements;
    private int size = 0;
    private static final int DEFAULT_CAPACITY = 10;

    public ArrayList() {
        elements = new Object[DEFAULT_CAPACITY];
    }

    // Добавить элемент в конец
    public void add(T value) {
        ensureCapacity();
        elements[size++] = value;
    }

    // Получить элемент по индексу
    @SuppressWarnings("unchecked")
    public T get(int index) {
        checkIndex(index);
        return (T) elements[index];
    }

    // Установить новое значение по индексу
    public void set(int index, T value) {
        checkIndex(index);
        elements[index] = value;
    }

    // Удалить элемент по индексу
    public void remove(int index) {
        checkIndex(index);
        int numMoved = size - index - 1;
        if (numMoved > 0) {
            System.arraycopy(elements, index + 1, elements, index, numMoved);
        }
        elements[--size] = null; // очистка ссылки
    }

    // Размер списка
    public int size() {
        return size;
    }

    // Вспомогательные методы
    private void ensureCapacity() {
        if (size == elements.length) {
            elements = Arrays.copyOf(elements, elements.length * 2); // увеличим в 2 раза
        }
    }

    private void checkIndex(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        }
    }

    // Вывод всех элементов
    public void printList() {
        System.out.print("[");
        for (int i = 0; i < size; i++) {
            System.out.print(elements[i]);
            if (i < size - 1) System.out.print(", ");
        }
        System.out.println("]");
    }
}

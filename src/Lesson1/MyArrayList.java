package Lesson1;

import java.util.Arrays;

public class MyArrayList<T> {
    private static final int DEFAULT_CAPACITY = 10;
    private int size = 0;
    private Object[] elements;

    public MyArrayList() {
        this.elements = new Object[DEFAULT_CAPACITY];
    }

    public int size() {
        return size;
    }

    public void add(T element) {
        if (size >= elements.length) {
            ensureCapacity();
        }
        elements[size++] = element;
    }

    public T get(int index) {
        checkIndex(index);
        return (T) elements[index];
    }

    public T set(int index, T element) {
        checkIndex(index);
        T oldValue = (T) elements[index];
        elements[index] = element;
        return oldValue;
    }

    public T remove(int index) {
        checkIndex(index);
        T removedElement = (T) elements[index];
        shiftElementsLeft(index);
        size--;
        return removedElement;
    }

    public void clear() {
        size = 0;
        elements = new Object[DEFAULT_CAPACITY];
    }

    public boolean contains(Object o) {
        for (int i = 0; i < size; i++) {
            if (elements[i].equals(o)) {
                return true;
            }
        }
        return false;
    }

    private void checkIndex(int index) {
        if (index < 0 || index > elements.length) {
            throw new IndexOutOfBoundsException("Индекс больше размера массива");
        }
    }

    private void ensureCapacity() {
        int newSize = elements.length + elements.length / 2 + 1;
        elements = Arrays.copyOf(elements, newSize);
    }

    private void shiftElementsLeft(int startIndex) {
        for (int i = startIndex; i < size - 1; i++) {
            elements[i] = elements[i + 1];
        }
        elements[size] = null;
    }

    @Override
    public String toString() {
        return "MyArrayList{" +
                "elements=" + Arrays.toString(elements) +
                '}';
    }
}

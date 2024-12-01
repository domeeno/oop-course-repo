package oop.practice;
public class CircularQueue<T> implements Queue<T> {
    private T[] queue;
    private int head, tail, size, capacity;

    public CircularQueue(int capacity) {
        this.capacity = capacity;
        this.queue = (T[]) new Object[capacity];
        this.head = 0;
        this.tail = 0;
        this.size = 0;
    }

    @Override
    public void enqueue(T item) {
        if (size == capacity) {
            throw new IllegalStateException("Queue is full!");
        }
        queue[tail] = item;
        tail = (tail + 1) % capacity;
        size++;
    }

    @Override
    public T dequeue() {
        if (isEmpty()) {
            throw new IllegalStateException("Queue is empty!");
        }
        T item = queue[head];
        queue[head] = null;
        head = (head + 1) % capacity;
        size--;
        return item;
    }

    @Override
    public T peek() {
        if (isEmpty()) {
            throw new IllegalStateException("Queue is empty!");
        }
        return queue[head];
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public int size() {
        return size;
    }
}

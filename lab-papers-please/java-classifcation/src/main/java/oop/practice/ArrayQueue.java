package oop.practice;
import java.util.ArrayList;

public class ArrayQueue<T> implements Queue<T> {
    private ArrayList<T> queue;

    public ArrayQueue() {
        this.queue = new ArrayList<>();
    }

    @Override
    public void enqueue(T item) {
        queue.add(item);
    }

    @Override
    public T dequeue() {
        if (isEmpty()) {
            throw new IllegalStateException("Queue is empty!");
        }
        return queue.remove(0);
    }

    @Override
    public T peek() {
        if (isEmpty()) {
            throw new IllegalStateException("Queue is empty!");
        }
        return queue.get(0);
    }

    @Override
    public boolean isEmpty() {
        return queue.isEmpty();
    }

    @Override
    public int size() {
        return queue.size();
    }
}

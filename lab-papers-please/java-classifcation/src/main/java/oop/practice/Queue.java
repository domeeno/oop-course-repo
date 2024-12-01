package oop.practice;

import java.util.List;

public interface Queue<T> {
    void enqueue(T element);
    T dequeue();
    boolean isEmpty();
    int size();
    List<T> getQueueList();
}

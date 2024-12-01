package oop.practice;

import java.util.LinkedList;
import java.util.List;

// Simple Queue Class
public class SimpleQueue implements Queue<Car> {
    private LinkedList<Car> queue;

    public SimpleQueue() {
        queue = new LinkedList<>();
    }

    @Override
    public void enqueue(Car car) {
        int index = 0;
        for (Car queuedCar : queue) {
            if (queuedCar.getId() > car.getId()) {
                break;
            }
            index++;
        }
        queue.add(index, car);
    }

    @Override
    public Car dequeue() {
        if (queue.isEmpty()) {
            return null;
        }
        return queue.removeFirst();
    }

    @Override
    public boolean isEmpty() {
        return queue.isEmpty();
    }

    @Override
    public int size() {
        return queue.size();
    }

    @Override
    public List<Car> getQueueList() {
        return queue;
    }
}

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.*;
import com.google.gson.Gson;

public class Main {
    public static void main(String[] args) {
        System.out.println("Car service application started\n");

        var semaphore = new Semaphore();

        List<Car> cars = readCarsFromJson("C:\\Users\\Admin\\IdeaProjects\\oop-course-repo\\lab-car-management\\cars.json");

        if (cars == null || cars.isEmpty()) {
            System.err.println("No cars found in cars.json");
            return;
        }

        System.out.println("Loaded " + cars.size() + " cars from cars.json\n");

        System.out.println("Routing Cars to stations...");
        for (var car : cars) {
            semaphore.routeCar(car);
        }

        System.out.println("\nServing cars\n");
        semaphore.serveAllCars();

        System.out.println("\nFinal stats\n");
        StatisticsTracker.getInstance().printStatistics();

        System.out.println("\nCar service app finished =)");
    }

    private static List<Car> readCarsFromJson(String filename) {
        JsonReader fileManager = new JsonReader(filename);
        String text = fileManager.readFile();

        if (text == null || text.isEmpty()) {
            System.err.println("Error reading " + filename + ": File is empty or doesn't exist");
            return null;
        }

        try {
            var gson = new Gson();
            Car[] carsArray = gson.fromJson(text, Car[].class);
            return Arrays.asList(carsArray);
        } catch (Exception e) {
            System.err.println("Error parsing " + filename + ": " + e.getMessage());
            return null;
        }
    }
}



class Car {
    private int id;
    private String type;
    private String passengers;
    private boolean isDining;
    private int consumption;

    public Car(int id, String type, String passengers, boolean isDining, int consumption) {
        this.id = id;
        this.type = type;
        this.passengers = passengers;
        this.isDining = isDining;
        this.consumption = consumption;
    }

    public int getId() { return id; }
    public String getType() { return type; }
    public String getPassengers() { return passengers; }
    public boolean isDining() { return isDining; }
    public int getConsumption() { return consumption; }

    @Override
    public String toString() {
        return "Car{" +
                "id=" + id +
                ", type='" + type + '\'' +
                ", passengers='" + passengers + '\'' +
                ", isDining=" + isDining +
                ", consumption=" + consumption +
                '}';
    }
}

abstract class Queue<T> {
    public abstract void enqueue(T item);
    public abstract T dequeue();
    public abstract boolean isEmpty();
    public abstract int size();
}

class ArrayQueue<T> extends Queue<T> {
    private List<T> items = new ArrayList<>();
    public void enqueue(T item) { items.add(item); }
    public T dequeue() {
        if (isEmpty()) return null;
        return items.remove(0);
    }
    public boolean isEmpty() { return items.isEmpty(); }
    public int size() { return items.size(); }
}

class LinkedListQueue<T> extends Queue<T> {
    private LinkedList<T> items = new LinkedList<>();
    public void enqueue(T item) { items.addLast(item); }
    public T dequeue() {
        if (isEmpty()) return null;
        return items.removeFirst();
    }
    public boolean isEmpty() { return items.isEmpty(); }
    public int size() { return items.size(); }
}

class CircularQueue<T> extends Queue<T> {
    private Object[] items;
    private int front = 0, rear = -1, size = 0, capacity;

    public CircularQueue(int capacity) {
        this.capacity = capacity;
        this.items = new Object[capacity];
    }

    public CircularQueue() { this(100); }

    public void enqueue(T item) {
        if (size == capacity) resize();
        rear = (rear + 1) % capacity;
        items[rear] = item;
        size++;
    }

    @SuppressWarnings("unchecked")
    public T dequeue() {
        if (isEmpty()) {
            return null;
        }
        T item = (T) items[front];
        items[front] = null;
        front = (front + 1) % capacity;
        size--;
        return item;
    }

    public boolean isEmpty() { return size == 0; }
    public int size() { return size; }

    private void resize() {
        int newCap = capacity * 2;
        Object[] newItems = new Object[newCap];
        for (int i = 0; i < size; i++) {
            newItems[i] = items[(front + i) % capacity];
        }
        items = newItems;
        front = 0;
        rear = size - 1;
        capacity = newCap;
    }
}

interface Dineable {
    void serveDinner(String carId);
}

interface Refuelable {
    void refuel(String carId, int consumption);
}

class PeopleDinner implements Dineable {
    public void serveDinner(String carId) {
        System.out.println("Serving dinner to people in car " + carId);
        StatisticsTracker.getInstance().incrementPeople();
        StatisticsTracker.getInstance().incrementDining();
    }
}

class RobotDinner implements Dineable {
    public void serveDinner(String carId) {
        System.out.println("Serving dinner to robots in car " + carId);
        StatisticsTracker.getInstance().incrementRobots();
        StatisticsTracker.getInstance().incrementDining();
    }
}

class ElectricStation implements Refuelable {
    public void refuel(String carId, int c) {
        System.out.println("Charging electric car " + carId);
        StatisticsTracker.getInstance().incrementElectric();
        StatisticsTracker.getInstance().addElectricConsumption(c);
    }
}

class GasStation implements Refuelable {
    public void refuel(String carId, int c) {
        System.out.println("Refueling gas car " + carId);
        StatisticsTracker.getInstance().incrementGas();
        StatisticsTracker.getInstance().addGasConsumption(c);
    }
}

class CarStation {
    private Dineable dining;
    private Refuelable refuel;
    private Queue<Car> queue;
    private String type;

    public CarStation(Dineable d, Refuelable r, Queue<Car> q, String type) {
        this.dining = d;
        this.refuel = r;
        this.queue = q;
        this.type = type;
    }

    public void addCar(Car car) {
        queue.enqueue(car);
    }

    public void serveCars() {
        if (queue.isEmpty()) return;
        System.out.println(type + ":");

        while (!queue.isEmpty()) {
            Car car = queue.dequeue();

            if (car == null) {
                continue; // Skip if null (shouldn't happen with fixes above)
            }

            if (car.isDining() && dining != null) {
                dining.serveDinner(String.valueOf(car.getId()));
            } else {
                if (car.getPassengers().equals("PEOPLE"))
                    StatisticsTracker.getInstance().incrementPeople();
                else
                    StatisticsTracker.getInstance().incrementRobots();

                StatisticsTracker.getInstance().incrementNotDining();
            }

            if (refuel != null)
                refuel.refuel(String.valueOf(car.getId()), car.getConsumption());
        }
        System.out.println();
    }
}

class Semaphore {
    private Map<String, CarStation> stations = new HashMap<>();

    public Semaphore() {
        stations.put("ELECTRIC-PEOPLE-DINING",
                new CarStation(new PeopleDinner(), new ElectricStation(), new ArrayQueue<>(), "ELECTRIC-PEOPLE-DINING"));

        stations.put("ELECTRIC-PEOPLE-NOTDINING",
                new CarStation(null, new ElectricStation(), new LinkedListQueue<>(), "ELECTRIC-PEOPLE-NOTDINING"));

        stations.put("ELECTRIC-ROBOTS-DINING",
                new CarStation(new RobotDinner(), new ElectricStation(), new CircularQueue<>(), "ELECTRIC-ROBOTS-DINING"));

        stations.put("ELECTRIC-ROBOTS-NOTDINING",
                new CarStation(null, new ElectricStation(), new ArrayQueue<>(), "ELECTRIC-ROBOTS-NOTDINING"));

        stations.put("GAS-PEOPLE-DINING",
                new CarStation(new PeopleDinner(), new GasStation(), new LinkedListQueue<>(), "GAS-PEOPLE-DINING"));

        stations.put("GAS-PEOPLE-NOTDINING",
                new CarStation(null, new GasStation(), new CircularQueue<>(), "GAS-PEOPLE-NOTDINING"));

        stations.put("GAS-ROBOTS-DINING",
                new CarStation(new RobotDinner(), new GasStation(), new ArrayQueue<>(), "GAS-ROBOTS-DINING"));

        stations.put("GAS-ROBOTS-NOTDINING",
                new CarStation(null, new GasStation(), new LinkedListQueue<>(), "GAS-ROBOTS-NOTDINING"));
    }

    public void routeCar(Car car) {
        String key = car.getType() + "-" + car.getPassengers() + "-" +
                (car.isDining() ? "DINING" : "NOTDINING");

        var station = stations.get(key);

        if (station != null) station.addCar(car);
        else System.err.println("No station found for car: " + car);
    }

    public void serveAllCars() {
        for (CarStation cs : stations.values()) {
            cs.serveCars();
        }
    }
}

class JsonReader {
    private String filename;

    public JsonReader(String filename) {
        this.filename = filename;
    }

    public String readFile() {
        var sb = new StringBuilder();

        try (BufferedReader br = new BufferedReader(new FileReader(new File(filename)))) {
            String line;
            while ((line = br.readLine()) != null) {
                sb.append(line).append("\n");
            }
        } catch (Exception e) {
            System.err.println("Error reading: " + filename + " -> " + e.getMessage());
            return null;
        }

        return sb.toString();
    }
}


class StatisticsTracker {
    private static StatisticsTracker instance;

    private int electricCount = 0;
    private int gasCount = 0;
    private int peopleCount = 0;
    private int robotsCount = 0;
    private int diningCount = 0;
    private int notDiningCount = 0;
    private int electricConsumption = 0;
    private int gasConsumption = 0;

    public static StatisticsTracker getInstance() {
        if (instance == null) instance = new StatisticsTracker();
        return instance;
    }

    synchronized void incrementElectric() { electricCount++; }
    synchronized void incrementGas() { gasCount++; }
    synchronized void incrementPeople() { peopleCount++; }
    synchronized void incrementRobots() { robotsCount++; }
    synchronized void incrementDining() { diningCount++; }
    synchronized void incrementNotDining() { notDiningCount++; }
    synchronized void addElectricConsumption(int c) { electricConsumption += c; }
    synchronized void addGasConsumption(int c) { gasConsumption += c; }

    void printStatistics() {
        System.out.println("{");
        System.out.println("  ELECTRIC: " + electricCount + ",");
        System.out.println("  GAS: " + gasCount + ",");
        System.out.println("  PEOPLE: " + peopleCount + ",");
        System.out.println("  ROBOTS: " + robotsCount + ",");
        System.out.println("  DINING: " + diningCount + ",");
        System.out.println("  NOT_DINING: " + notDiningCount + ",");
        System.out.println("  CONSUMPTION: {");
        System.out.println("    ELECTRIC: " + electricConsumption + ",");
        System.out.println("    GAS: " + gasConsumption);
        System.out.println("  }");
        System.out.println("}");
    }
}
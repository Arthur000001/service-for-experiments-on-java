package main.java.core.data_structures.circular_queue;

public class StartDataStruct {

    public static void start() {

        CircularQueue<Integer> queue = new CircularQueue<>(5);

        queue.enqueue(10);
        queue.enqueue(20);
        queue.enqueue(30);
        queue.enqueue(40);
        queue.enqueue(50);
        queue.printQueue(); // Queue: 10 20 30 40 50

        System.out.println("Dequeue: " + queue.dequeue()); // 10
        queue.enqueue(60);
        queue.printQueue(); // Queue: 20 30 40 50 60

        System.out.println("Peek: " + queue.peek()); // 20
        System.out.println("Is full? " + queue.isFull()); // true
        System.out.println("Size: " + queue.size()); // 5

    }

}

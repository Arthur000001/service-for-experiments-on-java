package main.java.core.data_structures.deque;

public class StartDataStruct {

    public static void start() {

        Deque<Integer> deque = new Deque<>();

        deque.addFirst(10);
        deque.addLast(20);
        deque.addFirst(5);
        deque.addLast(25);

        deque.printDeque(); // Deque: 5 10 20 25

        System.out.println("removeFirst(): " + deque.removeFirst()); // 5
        System.out.println("removeLast(): " + deque.removeLast());   // 25

        deque.printDeque(); // Deque: 10 20

        System.out.println("peekFirst(): " + deque.peekFirst()); // 10
        System.out.println("peekLast(): " + deque.peekLast());   // 20

    }

}

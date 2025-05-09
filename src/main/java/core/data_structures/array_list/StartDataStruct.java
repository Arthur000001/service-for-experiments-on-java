package main.java.core.data_structures.array_list;

public class StartDataStruct {

    public static void start() {

        ArrayList<Integer> list = new ArrayList<>();

        list.add(10);
        list.add(20);
        list.add(30);

        list.printList(); // [10, 20, 30]

        list.remove(1);   // удалим элемент с индексом 1 (20)
        list.printList(); // [10, 30]

        list.set(1, 99);
        list.printList(); // [10, 99]

        System.out.println("Element at index 0: " + list.get(0)); // 10
        System.out.println("Size: " + list.size()); // 2

    }

}

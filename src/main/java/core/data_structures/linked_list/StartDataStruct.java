package main.java.core.data_structures.linked_list;

public class StartDataStruct {

    public static void start() {

        LinkedList list = new LinkedList();

        list.add(10);
        list.add(20);
        list.add(30);
        list.printList(); // 10 -> 20 -> 30 -> null

        list.remove(20);
        list.printList(); // 10 -> 30 -> null

    }

}

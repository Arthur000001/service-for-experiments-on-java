package main.java.core.data_structures.map;

public class StartDataStruct {

    public static void start() {

        HashTable<String, Integer> map = new HashTable<>();

        map.put("apple", 5);
        map.put("banana", 3);
        map.put("orange", 7);

        System.out.println("apple = " + map.get("apple"));   // 5
        System.out.println("banana = " + map.get("banana")); // 3

        map.put("banana", 10); // обновим значение
        System.out.println("banana = " + map.get("banana")); // 10

        map.remove("apple");
        System.out.println("apple = " + map.get("apple"));   // null

        map.printTable(); // отладочный вывод всех элементов

    }

}

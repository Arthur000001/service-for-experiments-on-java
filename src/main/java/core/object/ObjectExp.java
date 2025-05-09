package main.java.core.object;

import model.Person;

public class ObjectExp {

    public static void checkObject() {

        Person p1 = new Person(1L, "Alice", "Smith", (short) 30);
        Person p2 = new Person(1L, "Alice", "Smith", (short) 30);
        Person p3 = new Person(2L, "Bob", "Johnson", (short) 25);

        // toString()
        System.out.println(p1);
        System.out.println(p2);
        System.out.println(p3);

        // equals()
        System.out.println("\nEquality checks:");
        System.out.println("p1.equals(p2): " + p1.equals(p2)); // true
        System.out.println("p1.equals(p3): " + p1.equals(p3)); // false

        // hashCode()
        System.out.println("\nHash codes:");
        System.out.println("p1.hashCode(): " + p1.hashCode());
        System.out.println("p2.hashCode(): " + p2.hashCode());
        System.out.println("p3.hashCode(): " + p3.hashCode());

    }

}

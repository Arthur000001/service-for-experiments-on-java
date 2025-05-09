package main.java.core.object;

public class StringExp {

    public static void checkStr() {
        String s1 = "hello";
        String s2 = "hello";
        String s3 = new String("hello");

        System.out.println(s1 == s2);       // true (один объект из пула)
        System.out.println(s1 == s3);       // false (s3 — новый объект)
        System.out.println(s1.equals(s3));  // true (содержимое совпадает)

    }


}

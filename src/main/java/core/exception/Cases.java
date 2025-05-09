package main.java.core.exception;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class Cases {

    static class Case1 {
        public static void checkNPE() {
            try {
                String s = null;
                if (s.equals("test")) {
                    System.out.println("equal");
                }
            } catch (NullPointerException e) {
                System.out.println("Пойман NullPointerException: " + e.getMessage());
            }

        }
    }

    static class Case2 {
        static class InvalidAgeException extends Exception {
            public InvalidAgeException(String message) {
                super(message);
            }
        }

        public void checkAge(int age) {
            try {
                if (age < 18) throw new InvalidAgeException("Возраст должен быть 18+");
            } catch (Cases.Case2.InvalidAgeException e) {
                System.out.println("Поймано исключение: " + e.getMessage());
            }
        }
    }

    static class Case3 {
        public static void checkBR() {
            InputStream is = Case3.class.getClassLoader().getResourceAsStream("file.txt");

            if (is == null) {
                System.out.println("❌ Файл file.txt не найден в папке resources.");
                return;
            }

            try (BufferedReader br = new BufferedReader(new InputStreamReader(is))) {
                System.out.println("📄 Содержимое файла: " + br.readLine());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    static class Case4 {
        public static int test() {
            try {
                return 1;
            } finally {
                return 2;
            }
        }
    }

}

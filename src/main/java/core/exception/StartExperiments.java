package main.java.core.exception;

public class StartExperiments {

    public static void main(String[] args) {
        System.out.println("Case 1: NullPointerException");
        Cases.Case1.checkNPE();

        System.out.println("\nCase 2: Custom Exception (InvalidAgeException)");
        new Cases.Case2().checkAge(16);

        System.out.println("\nCase 3: Try-with-resources (BufferedReader)");
        Cases.Case3.checkBR();

        System.out.println("\nCase 4: finally overriding return");
        System.out.println("Результат метода test(): " + Cases.Case4.test());
    }

}

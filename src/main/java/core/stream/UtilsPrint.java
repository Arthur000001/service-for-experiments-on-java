package main.java.core.stream;


import main.java.model.Employee;

import java.util.List;
import java.util.Map;

public class UtilsPrint {

    public static void printArray(List<Employee> elements, String nameMethod) {
        System.out.println("> All elements from " + nameMethod + ":");
        if (elements == null || elements.isEmpty()) {
            System.out.println("Collection empty");
        } else {
            elements.forEach(el -> System.out.println(el.toString()));
        }
        System.out.println();
    }

    public static void printNumber(double number, String nameMethod) {
        System.out.println("> Number from " + nameMethod + ": ");
        System.out.println(number);
        System.out.println();
    }

    public static void printMapNumber(Map<String, ? extends Number> map, String nameMethod) {
        System.out.println("> Number from " + nameMethod + ": ");
        System.out.println(map);
        System.out.println();
    }

    public static void printEmployee(Employee employee, String nameMethod) {
        System.out.println("> Employee from " + nameMethod + ": ");
        System.out.println(employee);
        System.out.println();
    }

}

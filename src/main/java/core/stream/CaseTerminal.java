package main.java.core.stream;

import static main.java.common.InputDataConstants.EMPLOYEES;

public class CaseTerminal {

    /**
     * Агрегирование данных:
     * 1. Найти средний возраст сотрудников в департаменте "HR".
     * 2. Подсчитать общее количество сотрудников в департаменте "Finance".
     */
    public static double averageAgeInHR() {
        return EMPLOYEES.stream()
                .filter(el -> "HR".equals(el.getDepartment()))
                .mapToInt(el -> el.getAge())
                .average()
                .orElse(0);
    }

    public static long countEmployeesInFinance() {
        return EMPLOYEES.stream()
                .filter(el -> "Finance".equals(el.getDepartment()))
                .count();
    }

    /**
     * Проверка наличия сотрудников:
     * - Есть ли хотя бы один сотрудник с зарплатой выше 100000?
     */
    public static boolean anyHighEarner() {
        return EMPLOYEES.stream()
                .anyMatch(e -> e.getSalary() > 100000);
    }

    /**
     * Получение минимального и максимального возраста:
     */
    public static int maxEmployeeAge() {
        return EMPLOYEES.stream()
                .mapToInt(e -> e.getAge())
                .max()
                .orElse(0);
    }

}

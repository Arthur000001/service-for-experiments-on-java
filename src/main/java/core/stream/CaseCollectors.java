package main.java.core.stream;

import main.java.model.Employee;

import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import static main.java.common.InputDataConstants.EMPLOYEES;

public class CaseCollectors {

    /**
     * Группировка сотрудников:
     * - Подсчитать количество сотрудников в каждом департаменте.
     */
    public static Map<String, Long> groupingData() {
        return EMPLOYEES.stream()
                .collect(Collectors.groupingBy(Employee::getDepartment, Collectors.counting()));
    }

    /**
     * Сбор сотрудников по департаментам:
     * - Получить список сотрудников по каждому департаменту.
     */
    public static Map<String, List<Employee>> groupingEmployees() {
        return EMPLOYEES.stream()
                .collect(Collectors.groupingBy(Employee::getDepartment));
    }

    /**
     * Средняя зарплата по департаменту:
     */
    public static Map<String, Double> averageSalaryByDepartment() {
        return EMPLOYEES.stream()
                .collect(Collectors.groupingBy(
                        Employee::getDepartment, Collectors.averagingDouble(Employee::getSalary)
                ));
    }

    /**
     * Список имён сотрудников по департаменту:
     */
    public static Map<String, Set<String>> namesByDepartment() {
        return EMPLOYEES.stream()
                .collect(Collectors.groupingBy(
                        Employee::getDepartment, Collectors.mapping(
                                Employee::getName, Collectors.toSet()
                        )
                ));
    }

    /**
     * Подсчёт сотрудников с зарплатой > 50000 по департаменту:
     */
    public static Map<String, Long> highEarnersByDepartment() {
        return EMPLOYEES.stream()
                .filter(e -> e.getSalary() > 50000)
                .collect(Collectors.groupingBy(Employee::getDepartment, Collectors.counting()));
    }

}

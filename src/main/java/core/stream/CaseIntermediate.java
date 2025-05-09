package main.java.core.stream;


import main.java.model.Employee;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import static main.java.common.InputDataConstants.EMPLOYEES;

public class CaseIntermediate {

    /**
     * Фильтрация сотрудников:
     * 1. Сотрудники старше 30 лет.
     * 2. Зарплата больше 50000.
     */
    public static List<Employee> filteringEmployee() {
        return EMPLOYEES.stream()
                .filter(el -> el.getAge() > 30)
                .filter(el -> el.getSalary() > 50000)
                .collect(Collectors.toList());
    }

    /**
     * Сортировка сотрудников:
     * 1. По возрасту.
     * 2. По департаменту, затем по зарплате (в пределах департамента).
     */
    public static List<Employee> sortingEmployee() {
        return EMPLOYEES.stream()
                .sorted(Comparator.comparing(Employee::getDepartment)
                        .thenComparing(Employee::getSalary))
                .collect(Collectors.toList());
    }

    /**
     * Ограничение и пропуск:
     * - Пропустить первых 3 сотрудников и взять следующих 5.
     */
    public static List<Employee> limitAndSkipEmployee() {
        return EMPLOYEES.stream()
                .skip(3)
                .limit(5)
                .collect(Collectors.toList());
    }

    /**
     * Удаление дубликатов:
     * - Вернуть уникальные департаменты.
     */
    public static List<String> distinctDepartments() {
        return EMPLOYEES.stream()
                .map(Employee::getDepartment)
                .distinct()
                .collect(Collectors.toList());
    }

    /**
     * Сбор данных в коллекции:
     * - Сотрудники департамента "IT", отсортированные по зарплате.
     */
    public static List<Employee> collectingDataIntoCollections() {
        return EMPLOYEES.stream()
                .filter(el -> "IT".equals(el.getDepartment()))
                .sorted(Comparator.comparing(Employee::getSalary))
                .collect(Collectors.toList());
    }

    /**
     * Поиск сотрудника:
     * - Любой сотрудник с зарплатой более 80000.
     */
    public static Employee searchEmployee() {
        return EMPLOYEES.stream()
                .filter(el -> el.getSalary() > 80000)
                .findAny()
                .orElse(null);
    }
}
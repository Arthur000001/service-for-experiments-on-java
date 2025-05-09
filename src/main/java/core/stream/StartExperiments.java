package main.java.core.stream;


import static main.java.core.stream.CaseCollectors.averageSalaryByDepartment;
import static main.java.core.stream.CaseCollectors.groupingData;
import static main.java.core.stream.CaseCollectors.groupingEmployees;
import static main.java.core.stream.CaseCollectors.highEarnersByDepartment;
import static main.java.core.stream.CaseCollectors.namesByDepartment;
import static main.java.core.stream.CaseIntermediate.*;
import static main.java.core.stream.CaseTerminal.anyHighEarner;
import static main.java.core.stream.CaseTerminal.averageAgeInHR;
import static main.java.core.stream.CaseTerminal.countEmployeesInFinance;
import static main.java.core.stream.CaseTerminal.maxEmployeeAge;
import static main.java.core.stream.UtilsPrint.printArray;
import static main.java.core.stream.UtilsPrint.printEmployee;
import static main.java.core.stream.UtilsPrint.printMapNumber;
import static main.java.core.stream.UtilsPrint.printNumber;

public class StartExperiments {

    public static void start() {
        startCaseIntermediate();
        startCaseTerminal();
        startCaseCollectors();
    }

    public static void startCaseIntermediate() {
        printArray(filteringEmployee(), "filteringEmployee");
        printArray(sortingEmployee(), "sortingEmployee");
        printArray(limitAndSkipEmployee(), "limitAndSkipEmployee");
        printArray(collectingDataIntoCollections(), "collectingDataIntoCollections");
        System.out.println("> Distinct departments:");
        distinctDepartments().forEach(System.out::println);
        System.out.println();
        printEmployee(searchEmployee(), "searchEmployee");
    }

    public static void startCaseTerminal() {
        printNumber(averageAgeInHR(), "averageAgeInHR");
        printNumber(countEmployeesInFinance(), "countEmployeesInFinance");
        System.out.println("> Any high earner: " + anyHighEarner());
        System.out.println("> Max employee age: " + maxEmployeeAge());
    }

    public static void startCaseCollectors() {
        printMapNumber(groupingData(), "groupingData");
        printMapNumber(averageSalaryByDepartment(), "averageSalaryByDepartment");
        printMapNumber(highEarnersByDepartment(), "highEarnersByDepartment");
        System.out.println("> Names by department:");
        namesByDepartment().forEach((dept, names) -> System.out.println(dept + " -> " + names));
        System.out.println();
        System.out.println("> Grouping employees:");
        groupingEmployees().forEach((dept, list) -> {
            System.out.println(dept + ":");
            list.forEach(System.out::println);
        });
        System.out.println();
    }

}
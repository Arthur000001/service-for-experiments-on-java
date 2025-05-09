package main.java.common;

import main.java.core.data_structures.tree_traversal.Node;
import main.java.model.Employee;

import java.util.Arrays;
import java.util.List;

public class InputDataConstants {

    public static final int[] ARRAY = {
            64, 34, 25, 12, 22, 11, 90, 32, 65, 10, 23, 45, 76, 29, 40, 26
    };

    public static final Node NODE_DEFAULT = Node.node("root")
            .addChild(
                    Node.node("child1")
                            .addChild(Node.node("child3"))
                            .addChild(Node.node("child4"))
            )
            .addChild(
                    Node.node("child2")
                            .addChild(Node.node("child5"))
            );

    public static final List<Employee> EMPLOYEES = Arrays.asList(
            new Employee("John", 28, "IT", 60000),
            new Employee("Alice", 34, "HR", 75000),
            new Employee("Bob", 45, "Finance", 90000),
            new Employee("Charlie", 32, "IT", 120000),
            new Employee("Diana", 29, "Finance", 50000),
            new Employee("Eve", 31, "IT", 70000),
            new Employee("Frank", 26, "HR", 45000)
    );

}

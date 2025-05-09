package main.java.core.data_structures.tree_traversal;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class Node {
    private final String value;
    private final List<Node> children = new ArrayList<>();

    public Node(String value) {
        this.value = value;
    }

    public static Node node(String value) {
        return new Node(value);
    }

    public Node addChild(Node child) {
        children.add(child);
        return this;
    }

    public Node addChildren(Stream<Node> stream) {
        stream.forEach(this::addChild);
        return this;
    }

    public Node addChildren(Node... nodes) {
        return addChildren(Arrays.stream(nodes));
    }

    public void printTree(String prefix) {
        System.out.println(prefix + value);
        for (Node child : children) {
            child.printTree(prefix + "  ");
        }
    }

    public List<Node> getChildren() {
        return children;
    }

    public String getValue() {
        return value;
    }
}
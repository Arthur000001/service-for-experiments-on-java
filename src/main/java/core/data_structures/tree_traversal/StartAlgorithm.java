package main.java.core.data_structures.tree_traversal;

import java.util.ArrayList;
import java.util.List;

import static main.java.common.InputDataConstants.NODE_DEFAULT;
import static main.java.core.data_structures.tree_traversal.NodeOperation.collectAllNodes;

public class StartAlgorithm {

    public static void start() {

        List<Node> allNodes = new ArrayList<>();
        collectAllNodes(NODE_DEFAULT, allNodes);
        printArrayNodes(allNodes);

    }

    private static void printArrayNodes(List<Node> allNodes) {
        System.out.println("Все узлы:");
        for (Node node : allNodes) {
            System.out.println(node.getValue());
        }
    }

}
package main.java.core.data_structures.tree_traversal;

import java.util.List;

public class NodeOperation {

    public static void collectAllNodes(Node node, List<Node> result) {
        if (node == null) {
            return;
        }

        result.add(node);

        for (Node child : node.getChildren()) {
            collectAllNodes(child, result);
        }
    }
}
package main.java.core.data_structures.stack;

public class StartDataStruct {

    public static void start() {

        Stack<Integer> stack = new Stack<>();

        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.printStack(); // Stack (top -> bottom): 3 2 1

        System.out.println("Pop: " + stack.pop()); // 3
        System.out.println("Peek: " + stack.peek()); // 2
        stack.printStack(); // Stack (top -> bottom): 2 1

        System.out.println("Is empty? " + stack.isEmpty()); // false
        System.out.println("Size: " + stack.size()); // 2

    }

}

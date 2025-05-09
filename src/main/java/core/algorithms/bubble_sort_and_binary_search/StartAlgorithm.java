package main.java.core.algorithms.bubble_sort_and_binary_search;

import static main.java.common.InputDataConstants.ARRAY;

public class StartAlgorithm {
    public static void start() {

        System.out.println("Неотсортированный массив:");
        printArray(ARRAY);

        BubbleSort.myBubbleSort(ARRAY);

        System.out.println("Отсортированный массив:");
        printArray(ARRAY);

        int target = 23;
        int result = BinarySearchAfterSort.binarySearch(ARRAY, target, 0);

        if (result == -1) {
            System.out.println("Элемент " + target + " отсутствует в списке");
        } else {
            System.out.println("Число " + target + " является " + (result + 1) + " элементом в списке");
        }
    }

    private static void printArray(int[] array) {
        for (int value : array) {
            System.out.print(value + " ");
        }
        System.out.println();
    }

}
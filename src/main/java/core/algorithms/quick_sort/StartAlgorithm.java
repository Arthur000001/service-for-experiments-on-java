package main.java.core.algorithms.quick_sort;

import static main.java.common.InputDataConstants.ARRAY;
import static main.java.core.algorithms.quick_sort.QuickSort.quickSort;

public class StartAlgorithm {
    public static void start() {
        System.out.print("STEPS: [");
        quickSort(ARRAY, 0, ARRAY.length - 1, true);
        System.out.print("] \n");
        for (int num : ARRAY) {
            System.out.print(num + " ");
        }
    }
}
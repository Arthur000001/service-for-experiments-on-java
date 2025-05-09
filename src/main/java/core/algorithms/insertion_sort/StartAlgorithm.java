package main.java.core.algorithms.insertion_sort;

import static main.java.common.InputDataConstants.ARRAY;
import static main.java.core.algorithms.insertion_sort.InsertionSort.insertionSort;

public class StartAlgorithm {
    public static void start() {

        insertionSort(ARRAY);

        for (int num : ARRAY) {
            System.out.print(num + " ");
        }
    }
}
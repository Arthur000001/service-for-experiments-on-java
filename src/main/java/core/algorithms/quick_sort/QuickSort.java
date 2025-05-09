package main.java.core.algorithms.quick_sort;

public class QuickSort {
    public static void quickSort(int[] array, int low, int high, boolean first) {
        if (low < high) {
            int pi = partition(array, low, high, first);
            quickSort(array, low, pi - 1, false);
            quickSort(array, pi + 1, high, false);
        }
    }

    private static int partition(int[] array, int low, int high, boolean first) {
        int pivot = array[high];
        if (first) {
            System.out.print("PIVOT: " + pivot);
        } else {
            System.out.print(", PIVOT: " + pivot);
        }
        int i = (low - 1);
        for (int j = low; j < high; j++) {
            if (array[j] <= pivot) {
                i++;
                int temp = array[i];
                array[i] = array[j];
                array[j] = temp;
                System.out.print(", TEMP:" + temp);
            }
        }
        int temp = array[i + 1];
        array[i + 1] = array[high];
        array[high] = temp;

        return i + 1;
    }

}
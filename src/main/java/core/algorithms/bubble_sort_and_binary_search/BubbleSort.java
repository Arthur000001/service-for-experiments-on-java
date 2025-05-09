package main.java.core.algorithms.bubble_sort_and_binary_search;

public class BubbleSort {
    public static void bubbleSort(int[] array) {

        int size = array.length;
        boolean swapped;

        for (int first = 0; first < size - 1; first++) {

            swapped = false;

            for (int second = 0; second < size - first - 1; second++) {
                if (array[second] > array[second + 1]) {

                    int temp = array[second];
                    array[second] = array[second + 1];
                    array[second + 1] = temp;
                    swapped = true;

                }
            }

            if (!swapped) {
                break;
            }
        }
    }

    public static void myBubbleSort(int[] array) {

        int size = array.length;

        for(int first = 0; first < size; first++) {


            for (int second = 0; second < size; second++) {

                if (array[first] < array[second]) {

                    int temp = array[first];
                    array[first] = array[second];
                    array[second] = temp;

                }
            }

        }

    }
}
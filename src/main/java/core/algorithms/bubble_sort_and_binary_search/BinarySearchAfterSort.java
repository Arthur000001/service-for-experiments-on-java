package main.java.core.algorithms.bubble_sort_and_binary_search;

public class BinarySearchAfterSort {

    public static int binarySearch(int[] array, int target, int left) {

        int right = array.length - 1;

        while (left <= right) {

            int middle = left + (right - left) / 2;

            if (array[middle] == target) {
                return middle;
            }

            if (array[middle] > target) {
                right = middle - 1;
            } else {
                left = middle + 1;
            }

        }

        return -1;
    }
}
package main.java.core.interviews.topic_string.remove_duplicates_from_sorted_array;

import java.util.Arrays;

public class Task {

    public static void main(String[] args) {
        long startTime = System.nanoTime();
        int [] nums = new int [] {0, 0, 1, 1, 1, 2, 2, 3, 3, 4};
        //getUniqueNumbers(nums);
        getUniqueNumbersNew(nums);
        long endTime = System.nanoTime();
        long duration = endTime - startTime;
        System.out.println("\n\n");
        System.out.println("Время выполнения main: " + duration + " наносекунд");
        System.out.println("Время выполнения main: " + (duration / 1_000_000) + " миллисекунд");
    }

    public static int getUniqueNumbers(int [] nums) {

        int [] mass = new int[nums.length];
        int counter = 0;

        for (int i = 0; i < nums.length; i++) {
            if (i == 0) {
                mass[counter] = nums[i];
                counter++;
            } else {
                if (mass[counter - 1] != nums[i]) {
                    mass[counter] = nums[i];
                    counter++;
                }
            }

        }

        System.out.println("Result: " + counter + " Mass = " + Arrays.toString(mass));

        System.arraycopy(mass, 0, nums, 0, nums.length);

        System.out.println("Result: " + counter + " Nums = " + Arrays.toString(mass));

        return counter;
    }

    public static int getUniqueNumbersNew(int [] nums) { //0, 0, 1, 1, 1, 2, 2, 3, 3, 4

        int counter = 1;

        for (int i = 1; i < nums.length; i++) {
            if (nums[counter - 1] != nums[i]) {
                nums[counter] = nums[i];
                counter++;
            }
        }

        System.out.println("Result: " + counter + " Nums = " + Arrays.toString(nums));

        return counter;
    }

}

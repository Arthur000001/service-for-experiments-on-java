package main.java.core.interviews.topic_string.no_theme;

import java.util.HashMap;
import java.util.Map;

public class Ex1_1 {
    public static void main(String[] args) {
        long startTime = System.nanoTime();
        int[] array = {1,2,4,5,6,1,5,3,2,6,3,8,3,4,3};
        System.out.println(getNumber(array));
        long endTime = System.nanoTime();
        long duration = endTime - startTime;
        System.out.println("Время выполнения main: " + duration + " наносекунд");
        System.out.println("Время выполнения main: " + (duration / 1_000_000) + " миллисекунд");
    }

    public static int getNumber(int[] array) { //1,2,4,5,6,1,5,3,2,6,3,8,3,4,3
        if (array != null && array.length > 0) {
            Map<Integer, Integer> map = new HashMap<>();

            for (int i = 0; i < array.length; i++) {
                if (map.containsKey(array[i])) {
                    map.computeIfPresent(array[i], (k, v) -> v + 1);
                } else {
                    map.put(array[i], 1);
                }
            }

            for (int i = 0; i < array.length; i++) {
                if (map.get(array[i]) == 1) {
                    return array[i];
                }
            }
        } else {
            throw new RuntimeException("Передан пустой массив");
        }
        throw new RuntimeException("Не удалось найти эллемент");
    }
}
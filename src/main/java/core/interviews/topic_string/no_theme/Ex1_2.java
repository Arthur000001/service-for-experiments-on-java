package main.java.core.interviews.topic_string.no_theme;

public class Ex1_2 {
    public static void main(String[] args) {
        long startTime = System.nanoTime();
        int result = getUniqueNumber(new int[] {1,2,4,5,6,1,5,3,2,6,3,8,3,4,3});
        System.out.println(String.format("This is unique number: {}", result));
        long endTime = System.nanoTime();
        long duration = endTime - startTime;
        System.out.println("Время выполнения main: " + duration + " наносекунд");
        System.out.println("Время выполнения main: " + (duration / 1_000_000) + " миллисекунд");
    }

    public static int getUniqueNumber(int [] mass) { //1,2,4,5,6,1,5,3,2,6,3,8,3,4,3
        int number = 0;
        for (int i = 0; i < mass.length; i++) {
            number = mass[i];
            boolean flag = false;
            for (int j = 0; j < mass.length; j++) {
                if (i != j) {
                    if (number == mass[j]) {
                        break;
                    } else {
                        if (j == mass.length-1 && flag) {
                            return number;
                        }
                        flag = true;
                    }
                }
            }
        }
        return number;
    }
}


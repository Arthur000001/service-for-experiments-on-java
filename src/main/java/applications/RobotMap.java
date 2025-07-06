package main.java.applications;
import java.util.Scanner;

public class RobotMap {
    private static final int SIZE = 15;
    private static char[][] map = new char[SIZE][SIZE];
    private static int robotX = 0;
    private static int robotY = 0;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        initMap();

        System.out.println("Управление: w - вверх, s - вниз, a - влево, d - вправо, q - выход");

        while (true) {
            printMap();
            System.out.print("Ход: ");
            String input = scanner.nextLine();

            if (input.equals("q")) break;
            moveRobot(input);
        }

        System.out.println("Игра окончена.");
    }

    private static void initMap() {
        for (int i = 0; i < SIZE; i++)
            for (int j = 0; j < SIZE; j++)
                map[i][j] = '.';

        map[robotY][robotX] = 'R';
    }

    private static void printMap() {
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                System.out.print(map[i][j] + " ");
            }
            System.out.println();
        }
    }

    private static void moveRobot(String direction) {
        int newX = robotX;
        int newY = robotY;

        switch (direction) {
            case "w": newY--; break;
            case "s": newY++; break;
            case "a": newX--; break;
            case "d": newX++; break;
            default: System.out.println("Неверная команда!"); return;
        }

        if (newX < 0 || newY < 0 || newX >= SIZE || newY >= SIZE) {
            System.out.println("Робот не может выйти за границы!");
            return;
        }

        map[robotY][robotX] = '.';
        robotX = newX;
        robotY = newY;
        map[robotY][robotX] = 'R';
    }
}


package main.java.applications;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Chess {
    private static final int SIZE = 8;
    private static final String[][] board = new String[SIZE][SIZE];
    private static final List<String> capturedByWhite = new ArrayList<>();
    private static final List<String> capturedByBlack = new ArrayList<>();


        public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        initBoard();

        boolean isWhiteTurn = true;

        System.out.println("Добро пожаловать в консольные шахматы!");
        System.out.println("Формат хода: e2 e4 (откуда-куда), 'exit' — выход");

        int countSteps = 1;

        while (true) {
            printBoard();
            System.out.println("⚪ Съедено белыми: " + String.join(" ", capturedByBlack));
            System.out.println("⚫ Съедено чёрными: " + String.join(" ", capturedByWhite));
            System.out.print((isWhiteTurn ? "⚫ Очередь чёрных. " : "⚪ Очередь белых. ") + "Ход №" + countSteps + ": ");
            String input = scanner.nextLine();

            if (input.equalsIgnoreCase("exit")) break;

            String[] parts = input.split(" ");
            if (parts.length != 2 || !isValidCoord(parts[0]) || !isValidCoord(parts[1])) {
                System.out.println("Неверный формат. Пример: e2 e4");
                continue;
            }

            int[] from = parseCoord(parts[0]);
            int[] to = parseCoord(parts[1]);

            if (movePiece(from, to, isWhiteTurn)) {
                isWhiteTurn = !isWhiteTurn; // только если ход прошёл успешно
            }
            countSteps++;
        }

        System.out.println("Игра завершена.");
    }


    private static void initBoard() {
        // Пешки
        for (int i = 0; i < SIZE; i++) {
            board[1][i] = "♟";
            board[6][i] = "♙";
        }

        // Фигуры
        String[] black = {"♜", "♞", "♝", "♛", "♚", "♝", "♞", "♜"};
        String[] white = {"♖", "♘", "♗", "♕", "♔", "♗", "♘", "♖"};
        board[0] = black;
        board[7] = white;

        // Пустые клетки
        for (int i = 2; i < 6; i++)
            for (int j = 0; j < SIZE; j++)
                board[i][j] = "．"; // Fullwidth точка
    }

    private static void printBoard() {
        String[] colLabels = {"Ａ", "Ｂ", "Ｃ", "Ｄ", "Ｅ", "Ｆ", "Ｇ", "Ｈ"};
        String[] rowLabels = {"８", "７", "６", "５", "４", "３", "２", "１"};

        // Верхняя подпись
        System.out.print("      ");
        for (String label : colLabels) {
            System.out.print(label + " ");
        }
        System.out.println();

        // Верхняя рамка (без уголков)
        System.out.print("     ");
        for (int i = 0; i < SIZE * 2.6; i++) {
            System.out.print("_");
        }
        System.out.println();

        // Поле
        for (int i = 0; i < SIZE; i++) {
            System.out.print(rowLabels[i] + " ");
            System.out.print("  │");
            for (int j = 0; j < SIZE; j++) {
                System.out.print(board[i][j]);
                if (j < SIZE - 1) System.out.print(" ");
            }
            System.out.println("│   " + rowLabels[i]);
        }

        // Нижняя рамка (без уголков)
        System.out.print("     ");
        for (int i = 0; i < SIZE * 2.6; i++) {
            System.out.print("‾");
        }
        System.out.println();

        // Нижняя подпись
        System.out.print("      ");
        for (String label : colLabels) {
            System.out.print(label + " ");
        }
        System.out.println();
    }

    private static boolean isValidCoord(String coord) {
        return coord.length() == 2 &&
                coord.charAt(0) >= 'a' && coord.charAt(0) <= 'h' &&
                coord.charAt(1) >= '1' && coord.charAt(1) <= '8';
    }

    private static int[] parseCoord(String coord) {
        int col = coord.charAt(0) - 'a';
        int row = 8 - (coord.charAt(1) - '0');
        return new int[]{row, col};
    }

    private static boolean movePiece(int[] from, int[] to, boolean isWhiteTurn) {
        String piece = board[from[0]][from[1]];
        if (piece.equals("．")) {
            System.out.println("На выбранной клетке нет фигуры.");
            return false;
        }

        boolean isWhitePiece = piece.matches("[♙♖♘♗♕♔]");
        if (isWhitePiece != isWhiteTurn) {
            System.out.println("Это не ваша фигура.");
            return false;
        }

        String target = board[to[0]][to[1]];
        if (!target.equals("．")) {
            if (isWhiteTurn) {
                capturedByWhite.add(target);
            } else {
                capturedByBlack.add(target);
            }
        }

        board[to[0]][to[1]] = piece;
        board[from[0]][from[1]] = "．";
        return true;
    }


}

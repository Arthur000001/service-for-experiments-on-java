package main.java.applications;

import java.util.Scanner;

public class ATM {
    private static String currentPin = "1";
    private static int balance = 10000;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            if (!authorize(scanner)) {
                return;
            }

            boolean sessionActive = true;

            while (sessionActive) {
                System.out.print("\n" +
                        "Выберите действие: \n" +
                        "1. Проверить баланс \n" +
                        "2. Снять деньги \n" +
                        "3. Внести деньги \n" +
                        "4. Выйти \n" +
                        "5. Сменить PIN \n" +
                        "Ваш выбор: "
                );
                String choice = scanner.nextLine();

                switch (choice) {
                    case "1":
                        System.out.printf("Ваш баланс: %d руб.\n", balance);
                        break;
                    case "2":
                        System.out.print("Сумма снятия: ");
                        int withdraw = parseIntAmount(scanner.nextLine());
                        if (withdraw <= 0 || withdraw % 10 != 0) {
                            System.out.println("Сумма должна быть положительной и кратной 10.");
                        } else if (withdraw > balance) {
                            System.out.println("Недостаточно средств.");
                        } else {
                            balance -= withdraw;
                            System.out.printf("Вы сняли %d руб.\nКупюры:\n", withdraw);
                            dispenseCash(withdraw);
                            System.out.printf("Ваш баланс: %d руб.\n", balance);
                        }
                        break;
                    case "3":
                        System.out.print("Сумма внесения: ");
                        int deposit = parseIntAmount(scanner.nextLine());
                        if (deposit <= 0 || deposit % 10 != 0) {
                            System.out.println("Сумма должна быть положительной и кратной 10.");
                        } else {
                            balance += deposit;
                            System.out.printf("Вы внесли %d руб.\n", deposit);
                            System.out.printf("Ваш баланс: %d руб.\n", balance);
                        }
                        break;
                    case "4":
                        System.out.print("Вы точно хотите выйти? (да'1'/нет'0'): ");
                        String confirmExit = scanner.nextLine().trim().toLowerCase();
                        if (confirmExit.equals("1")) {
                            sessionActive = false;

                            System.out.print("Хотите воспользоваться приложением заново? (да'1'/нет'0'): ");
                            String restart = scanner.nextLine().trim().toLowerCase();
                            if (!restart.equals("1")) {
                                System.out.println("Спасибо! До свидания.");
                                return;
                            }
                        }
                        break;
                    case "5":
                        changePin(scanner);
                        break;
                    default:
                        System.out.println("Неверный выбор.");
                }
            }
        }
    }

    private static boolean authorize(Scanner scanner) {
        while (true) {
            System.out.print("Введите PIN-код (или 'exit' для выхода): ");
            String pin = scanner.nextLine();

            if (pin.equalsIgnoreCase("exit")) {
                System.out.println("Выход из приложения.");
                return false;
            }

            if (pin.equals(currentPin)) {
                System.out.println("Добро пожаловать в банкомат!");
                return true;
            } else {
                System.out.println("Неверный PIN. Попробуйте ещё раз.");
            }
        }
    }

    private static void changePin(Scanner scanner) {
        System.out.print("Введите текущий PIN: ");
        String oldPin = scanner.nextLine();

        if (!oldPin.equals(currentPin)) {
            System.out.println("Неверный PIN.");
            return;
        }

        System.out.print("Введите новый PIN: ");
        String newPin1 = scanner.nextLine();

        System.out.print("Повторите новый PIN: ");
        String newPin2 = scanner.nextLine();

        if (!newPin1.equals(newPin2)) {
            System.out.println("PIN-коды не совпадают.");
        } else if (!isValidPin(newPin1)) {
            System.out.println("PIN должен состоять из 4 цифр.");
        } else {
            currentPin = newPin1;
            System.out.println("PIN успешно изменён.");
        }
    }

    private static void dispenseCash(int amount) {
        int[] denominations = {5000, 2000, 1000, 500, 200, 100, 50, 10};
        for (int denom : denominations) {
            int count = amount / denom;
            if (count > 0) {
                System.out.printf("  %dx %d руб.\n", count, denom);
                amount -= count * denom;
            }
        }
    }

    private static int parseIntAmount(String input) {
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            return -1;
        }
    }

    private static boolean isValidPin(String pin) {
        return pin.matches("\\d{4}");
    }
}



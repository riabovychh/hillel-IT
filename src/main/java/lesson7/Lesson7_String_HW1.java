package lesson7;

import java.util.Scanner;

public class Lesson7_String_HW1 {
    public static String repeatEnd(String yourString, int n) { // инициировала стрингу и целое число n
        if (n == 0) {
            return "";
        }
        String lastNSymbols = yourString.substring(yourString.length() - n);  // выбираю последние n символа строки
        return lastNSymbols.repeat(n); // повторяем эти n символы n раз
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введіть рядок: ");
        String clientInputString = scanner.nextLine();

        int n;
        while (true) {
            System.out.print("Введіть значення n: ");
            n = scanner.nextInt();

            if (n > clientInputString.length()) {
                System.out.println("Значення n не може бути більшим за довжину рядка.");
            } else {
                break;
            }
        }

        String result = repeatEnd(clientInputString, n);
        System.out.println("Результат: " + result);

        scanner.close();
    }
}

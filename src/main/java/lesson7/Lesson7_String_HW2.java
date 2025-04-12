package lesson7;

import java.util.Scanner;

public class Lesson7_String_HW2 {
    public static String mixString(String firstString, String secondString) {
        StringBuilder combineResult = new StringBuilder();  // cоздала новый стрингбилдер
        int minLength = Math.min(firstString.length(), secondString.length()); // если строки будут разной длины

        for (int i = 0; i < minLength; i++) {
            combineResult.append(firstString.charAt(i));  // cоздала стрингбилдер из символов строк по очереди
            combineResult.append(secondString.charAt(i));
        }

        if (firstString.length() > secondString.length()) { // если первая строка дольше
            combineResult.append(firstString.substring(minLength)); // добавляю остаток строки
        } else {                                                  // если вторая строка равна или дольше первой
            combineResult.append(secondString.substring(minLength));
        }

        return combineResult.toString();  // вывожу конечный результат стрингбилдера
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter first string: ");
        String firstString = scanner.nextLine();
        System.out.println("Enter second string: ");
        String secondString = scanner.nextLine();
        System.out.println("Mix result: " + mixString(firstString, secondString));
    }

}

package main.lesson7;

import java.util.Scanner;

public class Lesson7_String_HW3 {
    public static String xyzMiddle(String enteredString) {
        int checkIndex = enteredString.indexOf("xyz");  // ищем место, где начинается часть текста, которую ищем

        if (checkIndex == -1) {  // если этой части нет, возвращаем false
            return "Your string doesn't contain 'xyz' part.";
        }


        // очерчиваем границы искомой части текста
        int leftLength = checkIndex;  // левая часть от искомого текста
        // правая часть - длина строки минус левая часть и минус длина искомого текста
        int rightLength = enteredString.length() - (checkIndex + 3);

        // расчет разницы длины левой и правой части (не обязательно левая должна быть больше правой)
        if (Math.abs(leftLength - rightLength) <= 1) {
            return "true";   // возвращает true, если левая и правая часть отличаются не больше чем на 1 символ
        } else {
            return "false";
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        for (int i = 0; i < 3; i++) {
            System.out.print("Enter a string ( " + (i + 1) + " try): ");
            String enteredString = scanner.nextLine();
            System.out.println("You have entered: " + enteredString);
            System.out.println("Result: " + xyzMiddle(enteredString));
        }

        System.out.println("The cycle is finished.");

        scanner.close();
    }
}

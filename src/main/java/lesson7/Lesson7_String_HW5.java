package lesson7;

import java.util.Scanner;

public class Lesson7_String_HW5 {
    public static boolean xyzThere(String enteredString) {

        for (int i = 0; i <= enteredString.length() - 3; i++) { // перебираю строку с учетом того, что она может заканчиваться на xyz
            if (enteredString.substring(i, i + 3).equals("xyz")) {  // проверяю наличие xyz
                if (i > 0 && enteredString.charAt(i - 1) == '.') {  // проверяю, что перед найденным xyz нет точки
                    return false;  // если точка спереди есть - false
                }
                return true;  // если точки спереди нет - true
            }
        }
        return false;  // если xyz не найдено -  false
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        for (int i = 0; i < 3; i++) {
            System.out.print("Enter a string ( " + (i + 1) + " try): ");
            String enteredString = scanner.nextLine();
            System.out.println("You have entered: " + enteredString);
            System.out.println("Result: " + xyzThere(enteredString));
        }

        System.out.println("The cycle is finished.");

        scanner.close();
    }
}

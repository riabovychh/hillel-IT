import java.util.Scanner;

public class Lesson7_String_HW4 {
    public static String zipZap(String enteredString) {
        StringBuilder result = new StringBuilder();  // создаю новый стрингбилдер

        for (int i = 0; i < enteredString.length(); i++) {  // прохожусь по строке
            if (i + 2 < enteredString.length() && enteredString.charAt(i) == 'z' && enteredString.charAt(i + 2) == 'p') {
                result.append(enteredString.charAt(i));
                result.append(enteredString.charAt(i + 2));
                i += 2;  // пропускаю эту zip/zap часть
            } else {
                result.append(enteredString.charAt(i));  // если условие не выполнилось, добавляем этот символ в строку
            }
        }

        return result.toString();  // возвращаю полученную строку
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        for (int i = 0; i < 3; i++) {
            System.out.print("Enter a string ( " + (i + 1) + " try): ");
            String enteredString = scanner.nextLine();
            System.out.println("You have entered: " + enteredString);
            System.out.println("Result: " + zipZap(enteredString));
        }

        System.out.println("The cycle is finished.");

        scanner.close();
    }
}

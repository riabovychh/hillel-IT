package lesson8;

import java.util.Scanner;

public class Lesson8_HW6 {
    // Дано рядок. Потрібно повернути рядок, де кожен символ з оригінального рядка повторюється двічі.
    //
    //doubleChars("The") → "TThhee”
    //doubleChars("AAbb") → "AAAAbbbb”
    //doubleChars("Hi-There") → "HHii--TThheerree”
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter a string: ");
        String enteredString = sc.nextLine();
        System.out.println("New string with double chars: " + doubleChars(enteredString));

    }
    public static String doubleChars (String enteredString) {
        StringBuilder doubleResult = new StringBuilder();
        for (int i = 0; i < enteredString.length(); i++) {
            char c = enteredString.charAt(i);
            doubleResult.append(c).append(c);
        }
        return doubleResult.toString();
    }
}

package lesson8;

import java.util.Scanner;

public class Lesson8_HW9 {
    //Задача передбачає порівняння двох рядків та визначення, чи один рядок з'являється в кінці іншого рядка,
    // ігноруючи різницю у великих і малих літерах (тобто порівняння має бути "case insensitive" або нечутливим до регістру).
    // Функція поверне true, якщо хоча б один з рядків з'являється в кінці іншого.
    //
    //endsWith("AbC", "HiaBc") → true
    //endsWith("abc", "abXabc") → true
    //endsWith("Hiabc", "abc") → true
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter first string: ");
        String firstString = scan.nextLine();
        System.out.println("Enter second string: ");
        String secondString = scan.nextLine();
        System.out.println("Result of comparison: " + endsWith(firstString, secondString));

    }
    public static boolean endsWith (String firstString, String secondString) {
        firstString = firstString.toLowerCase();
        secondString = secondString.toLowerCase();
        return firstString.endsWith(secondString) || secondString.endsWith(firstString);
    }
}

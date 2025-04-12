package lesson8;

import java.util.Scanner;

public class Lesson8_HW7 {
    // Задача полягає в підрахунку кількості входжень підрядка "hi" у вказаному рядку.
    //
    //countHi("abc hi ho") → 1
    //countHi("ABChi hi") → 2ABChi hi
    //countHi("hihi") → 2
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter a string that could contain 'hi': ");
        String enteredString = sc.nextLine();
        System.out.println("This string contains 'hi' " + countHi(enteredString) + " times.");
    }
    public static int countHi (String enteredString) {
        int countHi = 0;
        for (int i = 0; i <= enteredString.length()-2; i++) {
            if (enteredString.substring(i, i + 2).equals("hi")) {
                countHi++;
            }
        }
        return countHi;
    }
}

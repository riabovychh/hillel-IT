package lesson8;

import java.util.Scanner;

public class Lesson8_HW8 {
    // Задача полягає в підрахунку кількості входжень підрядка "code" у вказаному рядку,
    // при цьому приймаються будь-які літери для символу 'd'.
    // Отже, рядки "cope" і "cooe" також вважаються входженням "code".
    //countCode("aaacodebbb") → 1
    //countCode("codexxcode") → 2
    //countCode("cozexxcope") → 2
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter a string that could contain 'code' or similar: ");
        String enteredString = sc.nextLine();
        System.out.println("This string contains 'code' or similar " + countCode(enteredString) + " times.");
    }
    public static int countCode (String enteredString) {
        int countCode = 0;
        for (int i = 0; i <= enteredString.length()-4; i++) {
            if (enteredString.charAt(i) == 'c' && enteredString.charAt(i + 1) == 'o' && enteredString.charAt(i + 3) == 'e') {
                countCode++;
            }
        }
        return countCode;
    }
}

package lesson8;

import java.util.Scanner;

public class Lesson8_HW1_1 {
    public static void main(String[] args) {
        // Ця задача полягає в порівнянні кількості входжень підрядків "cat" та "dog" у вказаному рядку.
        // Якщо обидва підрядки зустрічаються у рядку однакову кількість разів, повертається значення true,
        // в іншому випадку - false.
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter a string that could contain 'cat' and 'dog': ");
        String search = sc.nextLine();
        System.out.println("Does this string contain equal amount of 'cat' and 'dog': " + catDog(search));
    }

    public static boolean catDog(String searchingString) {
        int resultCat = 0;
        int resultDog = 0;
        for (int i = 0; i <= searchingString.length() - 3; i++) {
            if (searchingString.substring(i, i + 3).equals("cat")) {
                resultCat++;
            }
            if (searchingString.substring(i, i + 3).equals("dog")) {
                resultDog++;
            }
        }
        return (resultCat == resultDog);
    }
}

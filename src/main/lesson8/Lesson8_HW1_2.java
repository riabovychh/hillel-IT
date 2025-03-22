package main.lesson8;

import java.util.Scanner;

public class Lesson8_HW1_2 {
    // Повернути кількість парних цілих чисел у заданому масиві.
    // Зверніть увагу: оператор % "mod" обчислює залишок від ділення, наприклад, 5 % 2 дорівнює 1.
    //countEvenInts([2, 1, 2, 3, 4]) → 3
    //countEvenInts([2, 2, 0]) → 3
    //countEvenInts([1, 3, 5]) → 0
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the size of the array: ");
        int arrayLength = scanner.nextInt();
        int[] array = new int[arrayLength];
        System.out.print("Enter the elements of the array: ");
        for (int i = 0; i < arrayLength; i++) {
            array[i] = scanner.nextInt();
        }
        System.out.println("You entered the following array:");
        for (int i = 0; i < arrayLength; i++) {
            System.out.print(array[i] + " ");
        }
        System.out.println();
        System.out.println("This array contains " + countEvenIntegers(array) + " even numbers.");
    }
    public static int countEvenIntegers(int[] array) {
        int count = 0;
        for (int i = 0; i < array.length; i++) {
            if (array[i] % 2 == 0) {
                count++;
            }
        }
        return count;
    }
}

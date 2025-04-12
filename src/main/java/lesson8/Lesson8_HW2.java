package lesson8;

import java.util.Arrays;
import java.util.Scanner;

public class Lesson8_HW2 {
    // Повернути "центроване" середнє значення масиву цілих чисел, яке є середнім значенням елементів,
    // за винятком найбільшого та найменшого значень у масиві.
    // Якщо є кілька копій найменшого значення, ігнорувати лише одну копію, так само із найбільшим значенням.
    // Використовуйте цілочисельне ділення для обчислення кінцевого середнього.
    // Можна припускати, що довжина масиву дорівнює 3 або більше.
    //centeredAverage([1, 2, 3, 4, 100]) → 3
    //centeredAverage([1, 1, 5, 5, 10, 8, 7]) → 5
    //centeredAverage([-10, -4, -2, -4, -2, 0]) → -3
    public static void main(String[] args) {
        int[] enteredArray = {-10, -4, -2, -4, -2, 0};  // NEED TO CHANGE FOR TEST
        System.out.println("Your array: " + Arrays.toString(enteredArray));
        System.out.println("Centered average without smallest and biggest element: " + centeredAverage(enteredArray));
    }

    public static int centeredAverage (int[] array) {
        if (array.length <3) {
            return 0;
        }

        Arrays.sort(array);
        int sum = 0;
        for (int i = 1; i < array.length-1; i++) {  // skipped first and last
            sum += array[i];
        }
        return sum / (array.length -2); // without first and last
    }
}

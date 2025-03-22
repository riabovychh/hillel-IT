package main.lesson8;

import java.util.Arrays;

public class Lesson8_HW4 {
    // Повернути суму чисел у масиві, повертаючи 0 для порожнього масиву.
    // Однак число 13 - дуже нещасливе, тому воно не враховується,
    // а також числа, які йдуть одразу після числа 13, також не враховуються.
    //sumWithoutUnlucky13([1, 2, 2, 1]) → 6
    //sumWithoutUnlucky13([1, 1]) → 2
    //sumWithoutUnlucky13([1, 2, 2, 1, 13]) → 6

    public static void main(String[] args) {
        int[] enteredArray = {1, 2, 2, 1, 13, 23};  // NEED TO CHANGE FOR TEST
        System.out.println("Your array: " + Arrays.toString(enteredArray));
        System.out.println("Sum of elements without unlucky 13 and numbers after it: " + sumWithoutUnlucky13(enteredArray));
    }
    public static int sumWithoutUnlucky13 (int[] array) {
        if (array == null || array.length == 0) {
            return 0;
        }
        int sum = 0;
        for (int i = 0; i < array.length; i++) {
            if (array[i] != 13) {
                sum += array[i];
            } else {
                break;
            }
        }
        return sum;
    }
}

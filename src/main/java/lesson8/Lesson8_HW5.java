package lesson8;

import java.util.Arrays;

public class Lesson8_HW5 {
    public static void main(String[] args) {
// масив довжиною 1 або більше цілих чисел. Повернути різницю між найбільшим і найменшим значеннями у масиві.
// Зверніть увагу: вбудовані методи Math.min(v1, v2) та Math.max(v1, v2) повертають менше або більше з двох значень.
//differenceLargestSmallest([10, 3, 5, 6]) → 7
//differenceLargestSmallest([7, 2, 10, 9]) → 8
//differenceLargestSmallest([2, 10, 7, 2]) → 8
        int[] enteredArray = {2, 10, 7, 2};  // NEED TO CHANGE FOR TEST
        System.out.println("Your array: " + Arrays.toString(enteredArray));
        System.out.println("Difference between biggest and smallest element: " + differenceLargestSmallest(enteredArray));
        System.out.println("Difference by second way: " + differenceSecondWay(enteredArray));
    }
    public static int differenceLargestSmallest (int[] array) {  // without Math.min/max
        if (array == null || array.length == 0) {
            return 0;
        }
        Arrays.sort(array);
        int difference = array[array.length - 1] - array[0];
        return difference;
    }
    public static int differenceSecondWay (int[] array) {
        int min = array[0];
        int max = array[0];
        for (int i = 0; i < array.length; i++) {
            min = Math.min(min, array[i]);
            max = Math.max(max, array[i]);
        }
        return max - min;
    }
}

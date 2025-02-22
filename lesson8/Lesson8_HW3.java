import java.util.Arrays;

public class Lesson8_HW3 {
    public static void main(String[] args) {
// Повернути суму чисел у масиві, ігноруючи ділянки чисел, що починаються з 6 і закінчуються на наступному 7
// (кожен 6 буде наслідувати принаймні одна 7). Повернути 0 у випадку відсутності чисел.
//sumIgnoreSections([1, 2, 2]) → 5
//sumIgnoreSections([1, 2, 2, 6, 99, 99, 7]) → 5
//sumIgnoreSections([1, 1, 6, 7, 2]) → 4
        int[] enteredArray = {1, 1, 6, 7, 2};  // NEED TO CHANGE FOR TEST
        System.out.println("Your array: " + Arrays.toString(enteredArray));
        System.out.println("Sum of elements without the range from 6 to 7: " + sumIgnoreSections(enteredArray));

    }
    public static int sumIgnoreSections(int[] array) {
        if (array.length == 0) {
            return 0;
        }
        int sum = 0;
        boolean range = false;

        for (int i = 0; i < array.length; i++) {
            if (array[i] == 6 && !range) {
                range = true;
            } else if (array[i] == 7 && range) {
                range = false;
                continue;
            }

            if (!range) {
                sum += array[i];
            }
        }
        return sum;
    }
}

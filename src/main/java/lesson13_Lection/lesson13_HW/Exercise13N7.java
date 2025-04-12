package lesson13_Lection.lesson13_HW;
import java.util.*;

public class Exercise13N7 {
    // Треба визначити, чи є спільні елементи в двох множинах.
    // Приклад: Для LinkedHashSet A = [1, 2, 3, 4] та LinkedHashSet B = [3, 5, 6], очікуваний результат true.
    public static void main(String[] args) {
        LinkedHashSet<Integer> firstList = new LinkedHashSet<>(Arrays.asList(1, 2, 3, 4));
        LinkedHashSet<Integer> secondList = new LinkedHashSet<>(Arrays.asList(3, 5, 6));
        System.out.println(isCommonElement(firstList, secondList));
    }

    public static boolean isCommonElement (LinkedHashSet<Integer> list1, LinkedHashSet<Integer> list2) {
        for (Integer element : list1) {
            if (list2.contains(element)) {
                return true;
            }
        }
        return false;
    }
}

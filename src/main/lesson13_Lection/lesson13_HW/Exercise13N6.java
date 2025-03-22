package main.lesson13_Lection.lesson13_HW;

import java.util.*;

public class Exercise13N6 {
    // Умова: Знайдіть елемент, який зустрічається найчастіше у списку.
    //Приклад: Для списку [3, 1, 2, 2, 1, 2, 3, 3, 3], очікуваний результат 3,
    // оскільки він зустрічається найбільшу кількість разів.
    public static void main(String[] args) {

        List <Integer> givenList = Arrays.asList(3, 1, 2, 2, 1, 2, 3, 3, 3);
        System.out.println(countFrequency(givenList));


    }

    public static int countFrequency (List<Integer> list) {
        Map<Integer, Integer> countMap = new HashMap<>();

        for (int number : list) {
            countMap.put(number, countMap.getOrDefault(number, 0) + 1);
        }

        int mostFrequentElement = -1;
        int maxCount = 0;

        for (Map.Entry<Integer, Integer> entry : countMap.entrySet()) {
            if (entry.getValue() > maxCount) {
                maxCount = entry.getValue();
                mostFrequentElement = entry.getKey();
            }
        }
        return mostFrequentElement;
    }

}

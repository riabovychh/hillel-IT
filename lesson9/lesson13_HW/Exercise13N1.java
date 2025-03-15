package lesson13_HW;

import java.util.*;

// Задача полягає в тому, щоб створити і повернути Map<String, Integer>,
// де кожен унікальний рядок з масиву String[] буде ключем, а значенням буде його довжина.

public class Exercise13N1 {
    public static void main(String[] args) {
        String[] array ={"a", "bb", "a", "bb"};
        Map <String, Integer> resultMap = getLengthOfStrings(array);


        // довелось подовбатись, щоб вивести результат в такому форматi
        StringBuilder resultToString = new StringBuilder("{");
        resultMap.forEach((key, value) -> resultToString.append("\"" + key + "\": " + value + ", "));
        if (resultToString.length() > 1) {
            resultToString.setLength(resultToString.length() - 2);
        }
        resultToString.append("}");

        System.out.println(resultToString);

    }

    public static Map<String, Integer> getLengthOfStrings (String[] array) {
        Map<String, Integer> resultMap = new HashMap<>();

        for (String arrayString : array) {
            resultMap.putIfAbsent(arrayString, arrayString.length());
        }
        return resultMap;
    }
}

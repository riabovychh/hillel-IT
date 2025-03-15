package lesson13_HW;

import java.util.HashMap;
import java.util.Map;

// Це класичний алгоритм підрахунку слів:
// задано масив рядків, повернути Map<String, Integer> з ключем для кожного різного рядка та значенням -
// кількістю разів, як цей рядок зустрічається в масиві.
public class Exercise13N3 {
    public static void main(String[] args) {
        String[] array ={"c", "c", "c", "c"};
        Map<String, Integer> createdMap = countWords(array);

        StringBuilder resultToString = new StringBuilder("{");
        createdMap.forEach((key, value) -> resultToString.append("\"" + key + "\": " + value + ", "));
        if (resultToString.length() > 1) {
            resultToString.setLength(resultToString.length() - 2);
        }
        resultToString.append("}");

        System.out.println(resultToString);
    }

    public static Map<String, Integer> countWords (String[] array) {
        Map<String, Integer> resultMap = new HashMap<>();

        for (String arrayString : array) {
            resultMap.put(arrayString, resultMap.getOrDefault(arrayString, 0) + 1);
        }
        return resultMap;
    }

}

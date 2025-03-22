package main.lesson13_Lection.lesson13_HW;

import java.util.*;

public class Exercise13N5 {
    // Якщо рядок зустрічається в масиві вдруге, вчетверте, шосте рази і так далі,
    // додайте цей рядок до результату(тільки перше входження).
    // Якщо ж жодний рядок не зустрічається вдруге, поверніть пустий рядок.
    public static void main(String[] args) {
        String[] array ={"a", "", "a"};
        System.out.println(buildResultString(array));
    }

    public static String buildResultString(String[] array) {
        Map<String, Integer> countMap = new HashMap<>();
        Set<String> addedSet = new HashSet<>();
        StringBuilder resultString = new StringBuilder();

        for (String str : array) {
            countMap.put(str, countMap.getOrDefault(str, 0) + 1);
        }

        for (String str : array) {
            if (countMap.get(str) % 2 == 0 && !addedSet.contains(str)) {
                resultString.append(str);
                addedSet.add(str);
            }
        }

        return resultString.length() > 0 ? resultString.toString() : "";

    }


}

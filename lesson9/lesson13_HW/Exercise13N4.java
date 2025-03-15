package lesson13_HW;

import java.util.HashMap;
import java.util.Map;

public class Exercise13N4 {
    // Ця задача передбачає створення і повернення Map<String, String>,
    // де ключами будуть різні перші символи зустрінутих рядків, а значеннями будуть всі рядки,
    // які починаються з цього символу, об'єднані у порядку їх зустрічі у вихідному масиві.
    public static void main(String[] args) {
        String[] array ={"aa", "bb", "cc", "aAA", "cCC", "d"};
        Map<String, String> createdMap = mergeStringsByFirstChar(array);

        StringBuilder resultToString = new StringBuilder("{");
        createdMap.forEach((key, value) -> resultToString.append("\"" + key + "\": \"" + value + "\", "));
        if (resultToString.length() > 1) {
            resultToString.setLength(resultToString.length() - 2);
        }
        resultToString.append("}");

        System.out.println(resultToString);
    }

    public static Map<String, String> mergeStringsByFirstChar (String[] array){
        Map<String, String> resultMap = new HashMap<>();

        for (String arrayString : array) {
            char firstChar = arrayString.charAt(0);
            String firstLetter = String.valueOf(firstChar);
            resultMap.put(firstLetter, resultMap.getOrDefault(firstLetter, "") + arrayString);
        }
        return resultMap;
    }
}

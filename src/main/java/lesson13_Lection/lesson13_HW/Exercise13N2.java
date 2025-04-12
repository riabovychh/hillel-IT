package lesson13_Lection.lesson13_HW;
import java.util.*;


// Завдання полягає в тому, щоб створити і повернути Map<String, String>,
// де ключами будуть перші символи кожного рядка з непорожнього масиву String[],
// а значеннями будуть останні символи відповідних рядків

import java.util.Map;

public class Exercise13N2 {
    public static void main(String[] args) {
        String[] array ={"man", "moon", "good", "night"};
        Map <String, String> createdMap = getLengthOfStrings(array);

        StringBuilder resultToString = new StringBuilder("{");
        createdMap.forEach((key, value) -> resultToString.append("\"" + key + "\": \"" + value + "\", "));
        if (resultToString.length() > 1) {
            resultToString.setLength(resultToString.length() - 2);
        }
        resultToString.append("}");

        System.out.println(resultToString);

    }

    public static Map<String, String> getLengthOfStrings (String[] array) {
        Map<String, String> resultMap = new HashMap<>();

        for (String arrayString : array) {
            resultMap.putIfAbsent(String.valueOf(arrayString.charAt(0)), String.valueOf(arrayString.charAt(arrayString.length()-1)));
        }
        return resultMap;
    }
}

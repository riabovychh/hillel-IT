package main.lesson12_HW;

import java.util.*;

public class Main {
    public static void main(String[] args) {

        List<Integer> numbers = new ArrayList<>();
        numbers.add(3);
        numbers.add(14);
        numbers.add(15);
        numbers.add(92);
        numbers.add(6);

        List<String> pib = new ArrayList <>();
        pib.add("Tetiana");
        pib.add("Serhiivna");
        pib.add("Riabovych");

        Set <Integer> setCheck = new HashSet<>();
        setCheck.add(4);
        setCheck.add(4);
        setCheck.add(5);
        System.out.println("Let's check Set collection to double check that it contains only unique elements:");
        setCheck.forEach(item -> System.out.println(item));

        Map<String, String> ukraineCities = new HashMap<>();
        ukraineCities.put("Vinnytsia", "043/2");
        ukraineCities.put("Dnipro", "056/2");
        ukraineCities.put("Donetsk", "062/2");
        ukraineCities.put("Zhytomyr", "041/2");
        ukraineCities.put("Zaporizhzhia", "061/2");
        ukraineCities.put("Ivano-Frankivsk", "034/2");
        ukraineCities.put("Kyiv", "044");
        ukraineCities.put("Kropivnytskyi", "052/2");
        ukraineCities.put("Luhansk", "064/2");
        ukraineCities.put("Lutsk", "033/22");
        ukraineCities.put("Lviv", "032/2");
        ukraineCities.put("Mykolaiv", "051/2");
        ukraineCities.put("Odesa", "048/2");
        ukraineCities.put("Poltava", "053/2");
        ukraineCities.put("Rivne", "036/2");
        ukraineCities.put("Simferopol", "069/2");
        ukraineCities.put("Sumy", "054/2");
        ukraineCities.put("Ternopil", "035/2");
        ukraineCities.put("Uzhhorod", "031/22");
        ukraineCities.put("Kharkiv", "057/2");
        ukraineCities.put("Kherson", "035/2");
        ukraineCities.put("Khmelnytskyi", "038/22");
        ukraineCities.put("Cherkasy", "047/2");
        ukraineCities.put("Chernivtsi", "037/22");
        ukraineCities.put("Chernihiv", "046/22");



    }

}

package main.lesson13_Lection;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        // по обгорткам -
//        char -> Character
//        byte -> Byte
//        short -> Short
//        int -› Integer
//        long -> Long
//        double -> Double
//        float -> Float
//        boolean -> Boolean

        // ArrayList - быстрый поиск, быстрое добавление в конец списка, но медленное добавление в начало или середину списка
        // LinkedList - быстрая вставка куда-либо, в том числе в начале или середине списка, но медленный поиск
        // Vector - синхронизированный ArrayList (для многопоточности)
        // Stack - вспомагательный елемент Vectorа
        ArrayList<Integer> integers = new ArrayList<>(100); // можно указать кол-во элементов. Если не указать, будет по дефолту 10

        integers.add(5);   // ця 5 будет не пимитивом, а оберткой
        integers.add(10);

        LinkedList<Integer> linkedList = new LinkedList<>();

        // Set - множество, без дублей!
        // HashSet - immutable обьекты, быстрее поиск для них
        // TreeSet - отсортированные елементы, mutable обьекты, быстрее поиск для них



    }
}

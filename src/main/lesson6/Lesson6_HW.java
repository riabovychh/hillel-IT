package main.lesson6;

import java.util.Arrays;
import java.util.Scanner;

public class Lesson6_HW {
    public static double calculateAverage(int[] massive) {
        if (massive == null || massive.length == 0) {
            return 0;
        }
        int sum = 0;
        for (int number : massive) {
            sum += number;
        }
        return (double) sum / massive.length;
    }

    public static int findMaxElement(int[] massive) {
        if (massive == null || massive.length == 0) {
            return 0;
        }
        int max = massive[0];
        for (int number : massive) {
            if (number > max) {
                max = number;
            }
        }
            return max;
        }

    public static int findMinElement(int[] massive) {
        if (massive == null || massive.length == 0) {
            return 0;
        }
        int min = massive[0];
        for (int number : massive) {
            if (number < min) {
                min = number;
            }
        }
        return min;
    }

    public static void printMassiveInRevert (int[] massive) {
        if (massive == null || massive.length == 0) {
            return;
        }
        for (int lastElement = massive.length - 1; lastElement>= 0; lastElement --) {
                System.out.print(massive[lastElement] + " ");
            }
        System.out.println();
    }

    public static boolean contains(int[] massive, int target) {
        if (massive == null || massive.length == 0) {
            return false;
        }
        for (int element : massive) {
            if (element == target) {
                return true;
            }
        }
        return false;
    }


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Кiлькiсть елементiв в масивi: ");
        int number = sc.nextInt();
        int[] massive = new int[number];
        System.out.println("Введiть значення кожного елементу в масивi: ");
        for (int element = 0; element < number; element++) {
            massive[element] = sc.nextInt();
        }
        System.out.println("Ось ваш масив: " + Arrays.toString(massive));

        System.out.println("Середнє значення елементів в масивi:" + calculateAverage(massive));

        System.out.println("Максимальне значення в масивi:" + findMaxElement(massive));

        System.out.println("Miнiмальне значення в масивi:" + findMinElement(massive));

        System.out.println("Елементи в зворотньому порядку: ");
        printMassiveInRevert(massive);

        System.out.println("Введiть значення, яке хочете знайти в масивi:");
        int target = sc.nextInt();
        if (contains(massive, target)) {
            System.out.println("Число " + target + " є в масиві.");
        } else {
            System.out.println("Число " + target + " немає в масиві.");
        }
        sc.close();
    }
}

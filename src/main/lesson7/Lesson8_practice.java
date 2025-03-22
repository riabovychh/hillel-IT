package main.lesson7;

import java.util.Scanner;

public class Lesson8_practice {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter string: ");
        String input = sc.nextLine();
        System.out.println(input.length());
        System.out.println(input.contains("xyz"));
        int index = input.indexOf("xyz");
        if (index>1 && input.charAt(index-1) !='.') {
            System.out.println(true);
        }
    }

}

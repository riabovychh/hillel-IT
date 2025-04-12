package lesson10_Lection;

import lesson9_Lection.Cat;

import java.util.Date;

public class Main {
    public static void main(String[] args) {
        Dog dog = new Dog("Molli", new Date(2020,02,24), "Beige", 10);
        Cat cat = new Cat("Barsik",new Date(2022,02,24), "Pink", 4.5);
        System.out.println(cat.getName());

    dog.voice();
    cat.voice();
    }




}

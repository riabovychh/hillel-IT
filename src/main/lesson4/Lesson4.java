package main.lesson4;

public class Lesson4 {

    public static int square (int firstNumber) {                     // метод для розрахунку квадрату числа
        int squareResult = firstNumber * firstNumber;
        return squareResult;
    }

    public static double volume (double radius, double height) {       // метод розрахунку об'єму цилiндра
        double volumeCalculation = Math.PI * Math.pow(radius, 2) * height;
        return volumeCalculation;
    }

    public static int calcToPower (int firstNumberA, int secondNumberB) {    // метод розрахунку одного числа в степенi iншого
        int powerCalculation = (int) Math.pow(firstNumberA, secondNumberB);
        return powerCalculation;
    }


    public static void main(String[] args) {

        int firstNumber = Integer.parseInt(args[0]);
        int squareResult = square(firstNumber);
        System.out.println("1. Введіть ціле число: " + firstNumber);
        System.out.println("   Квадрат числа " + firstNumber + " дорівнює " + squareResult);

        double radius = Double.parseDouble(args[1]);
        double height = Double.parseDouble(args[2]);
        double volumeCalcuation = volume(radius, height);
        System.out.println("2. Об'єм циліндра з радіусом " + radius + " і висотою " + height + " дорівнює " + volumeCalcuation);

        int firstNumberA = Integer.parseInt(args[3]);
        int secondNumberB = Integer.parseInt(args[4]);
        int powerCalculation = calcToPower(firstNumberA, secondNumberB);
        System.out.println("3. Введіть a: " + firstNumberA);
        System.out.println("   Введіть b: " + secondNumberB);
        System.out.println("   Результат " + firstNumberA + "^" + secondNumberB + " дорівнює " + powerCalculation);
    }
}

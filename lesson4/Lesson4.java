import java.sql.SQLOutput;

public class Lesson4 {
    public static void main(String[] args) {
        int x = 5;
        int y = x*x;
        System.out.println("1. Введіть ціле число: " + x);
        System.out.println("   Квадрат числа " + x + " дорівнює " + y);

        double pi = 3.14159265358979323846;
        double radius = 4.53;
        double high = 11.52;
        double v =  pi*Math.pow(radius, 2)*high;
        System.out.println("2. Об'єм циліндра з радіусом " + radius + " і висотою " + high + " дорівнює " + v);

        int a = 4;
        int b = 3;
        int c = (int) Math.pow(a, b);
        System.out.println("3. Введіть a: " + a);
        System.out.println("   Введіть b: " + b);
        System.out.println("   Результат " + a + "^" + b + " дорівнює " + c);
    }
}

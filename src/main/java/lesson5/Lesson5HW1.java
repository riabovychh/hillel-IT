package lesson5;

public class Lesson5HW1 {
    public static String checkAge (int userAge) {
        if (userAge < 18) {
            return "Ви не є дорослою особою";
        } else {
            return "Ви доросла особа";
        }
    }


    public static void main(String[] args) {

        int userAge = Integer.parseInt(args[0]);
        System.out.println(checkAge(userAge));
    }
}

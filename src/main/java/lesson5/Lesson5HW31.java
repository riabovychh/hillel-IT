package lesson5;

public class Lesson5HW31 {
        public static String calcSumToN (int indicatedNumber) {
        if (indicatedNumber <= 0) {
            return "Хибні вхідні параметри";
        }
        String result = "";

        for (int startNumber = 1; startNumber <= indicatedNumber; startNumber++) {
            result += startNumber + " ";
        }
        return result;
    }


    public static void main(String[] args) {

        int indicatedNumber = Integer.parseInt(args[0]);
        String result = Lesson5HW31.calcSumToN(indicatedNumber);
        System.out.println(result);
    }
    }


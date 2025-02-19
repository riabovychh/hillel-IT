public class Lesson5HW2 {
    public static boolean isPerfectSquare (int numberCalcSquareRoot) {
        if (numberCalcSquareRoot < 0) {
            return false;
        }
            int squareRoot = (int) Math.sqrt(numberCalcSquareRoot);
            return squareRoot * squareRoot == numberCalcSquareRoot;
        }



    public static void main (String[] args) {

        int numberCalcSquareRoot = Integer.parseInt(args[0]);
        boolean result = isPerfectSquare(numberCalcSquareRoot);

        if (result) {
            System.out.println("true - " + numberCalcSquareRoot + " є квадратом цілого числа.");
        } else {
            System.out.println("false - " + numberCalcSquareRoot + " не є квадратом цілого числа.");
        }
    }
}
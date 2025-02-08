public class Lesson5HW5 {
    public static boolean isPrime(int indicatedNumber) {
        if (indicatedNumber <= 1) {
            return false;
        }

        for (int startNumber = 2; startNumber <= Math.sqrt(indicatedNumber); startNumber++) {
            if (indicatedNumber % startNumber == 0) {
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        int indicatedNumber = Integer.parseInt(args[0]);
        String result = isPrime(indicatedNumber) ? "True" : "False";
        System.out.println(result);
    }
}
